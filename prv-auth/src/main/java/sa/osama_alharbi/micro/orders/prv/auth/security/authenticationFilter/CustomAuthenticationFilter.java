package sa.osama_alharbi.micro.orders.prv.auth.security.authenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.ClientPrincipal;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.google.ClientGoogleAuthenticationToken;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.usernamePassword.ClientUsernamePasswordAuthenticationToken;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.manager.ManagerPrincipal;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.manager.emailPassword.ManagerEmailPasswordAuthenticationToken;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.manager.phoneNumberPassword.ManagerPhoneNumberPasswordAuthenticationToken;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

//@Component
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String pathUrl = request.getServletPath();
        if(pathUrl.equals("/login/client/google")){
            String email = request.getParameter("email");
            ClientGoogleAuthenticationToken clientGoogleAuthenticationToken =
                    new ClientGoogleAuthenticationToken(email);
            return getAuthenticationManager().authenticate(clientGoogleAuthenticationToken);
        }else if(pathUrl.equals("/login/client/usernamePassword")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            ClientUsernamePasswordAuthenticationToken clientUsernamePasswordAuthenticationToken =
                    new ClientUsernamePasswordAuthenticationToken(username,password);
            return getAuthenticationManager().authenticate(clientUsernamePasswordAuthenticationToken);
        }else if(pathUrl.equals("/login/manager/phoneNumberPassword")){
            String phoneNumber = request.getParameter("phoneNumber");
            String password = request.getParameter("password");
            ManagerPhoneNumberPasswordAuthenticationToken managerPhoneNumberPasswordAuthenticationToken =
                    new ManagerPhoneNumberPasswordAuthenticationToken(phoneNumber,password);
            return getAuthenticationManager().authenticate(managerPhoneNumberPasswordAuthenticationToken);
        }else if(pathUrl.equals("/login/manager/emailPassword")){
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            ManagerEmailPasswordAuthenticationToken managerEmailPasswordAuthenticationToken =
                    new ManagerEmailPasswordAuthenticationToken(email,password);
            return getAuthenticationManager().authenticate(managerEmailPasswordAuthenticationToken);
        }
        throw new ProviderNotFoundException("errrrr "+pathUrl);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        String access_token = "";


        //TODO use JWT
        if(ClientPrincipal.class.equals(authentication.getPrincipal().getClass())) {
            ClientPrincipal user = (ClientPrincipal) authentication.getPrincipal();
            if(user.getClient() != null){
                access_token = "client-"+user.getClient().getId();
            }
        }else if(ManagerPrincipal.class.equals(authentication.getPrincipal().getClass())) {
            ManagerPrincipal user = (ManagerPrincipal) authentication.getPrincipal();
            if(user.getClient() != null){
                access_token = "manager-"+user.getClient().getId();
            }
        }

        HashMap<String,String> map = new HashMap<>();
        map.put("access_token",access_token);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(),map);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }


}
