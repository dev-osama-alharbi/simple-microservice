package sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.google;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.ClientPrincipal;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.usernamePassword.ClientUsernamePasswordAuthenticationToken;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.usernamePassword.ClientUsernamePasswordUserDetailsService;

@Component
@RequiredArgsConstructor
@Slf4j
public class ClientGoogleAuthenticationProvider implements AuthenticationProvider {
    private final ClientGoogleUserDetailsService clientGoogleUserDetailsService;
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        log.debug("new App authenticate with (user = {}) && (pass = {})",email);

        ClientPrincipal clientPrincipal = clientGoogleUserDetailsService.loadUserByUsername(email);

        if (clientPrincipal != null){
            if(!email.equals(clientPrincipal.getUsername())){
                log.debug("passwordEncoder.matches");
                return new ClientGoogleAuthenticationToken(clientPrincipal,password);
            }else{
                log.debug("passwordEncoder BadCredentialsException");
                throw new BadCredentialsException("BadCredentialsException");
            }
        }else{
            log.debug("UsernameNotFoundException");
            throw new UsernameNotFoundException("");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(ClientGoogleAuthenticationToken.class);
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
