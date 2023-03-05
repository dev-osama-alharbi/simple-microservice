package sa.osama_alharbi.micro.orders.prv.auth.security.authorization;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import sa.osama_alharbi.micro.orders.core.db.dto.LoginDetails;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {
    private final String PrefixesAuthorizationHeader = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().startsWith("/login")) {
        } else {
            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader != null && authorizationHeader.startsWith(PrefixesAuthorizationHeader)) {
                String token = authorizationHeader.substring(PrefixesAuthorizationHeader.length());

                //TODO validate via JWT
                if(token.startsWith("client")){
                    String[] tokenArgs = token.split("-");
                    try{
                        int id = Integer.parseInt(tokenArgs[1]);
                        if(id>= 1){
                            LoginDetails loginDetails = new LoginDetails(id,"client");
                            request.setAttribute("loginDetails",loginDetails);


                            UsernamePasswordAuthenticationToken authenticationToken =
                                    new UsernamePasswordAuthenticationToken(loginDetails, null, new ArrayList<>());
                            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                        }else{
                            response.setStatus(HttpStatus.FORBIDDEN.value());
                        }
                    }catch (Exception e){
                        response.setStatus(HttpStatus.FORBIDDEN.value());
                    }
                }else if(token.startsWith("manager")){
                    String[] tokenArgs = token.split("-");
                    try{
                        int id = Integer.parseInt(tokenArgs[1]);
                        if(id>= 1){
                            LoginDetails loginDetails = new LoginDetails(id,"manager");
                            request.setAttribute("loginDetails",loginDetails);



                            UsernamePasswordAuthenticationToken authenticationToken =
                                    new UsernamePasswordAuthenticationToken(loginDetails, null, new ArrayList<>());
                            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                        }else{
                            response.setStatus(HttpStatus.FORBIDDEN.value());
                        }
                    }catch (Exception e){
                        response.setStatus(HttpStatus.FORBIDDEN.value());
                    }
                }else {
                    response.setStatus(HttpStatus.FORBIDDEN.value());
                }

            } else {
                response.setStatus(HttpStatus.FORBIDDEN.value());
            }
            filterChain.doFilter(request, response);
        }
    }
}