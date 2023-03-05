package sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.usernamePassword;

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

@Component
@RequiredArgsConstructor
@Slf4j
public class ClientUsernamePasswordAuthenticationProvider implements AuthenticationProvider {
    private final ClientUsernamePasswordUserDetailsService clientUsernamePasswordUserDetailsService;
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        log.debug("new App authenticate with (user = {}) && (pass = {})",username,password);

        ClientPrincipal clientPrincipal = clientUsernamePasswordUserDetailsService.loadUserByUsername(username);

        if (clientPrincipal != null){
            if(passwordEncoder.matches(password,clientPrincipal.getPassword())){
                log.debug("passwordEncoder.matches");
                return new ClientUsernamePasswordAuthenticationToken(clientPrincipal,password);
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
        return authentication.equals(ClientUsernamePasswordAuthenticationToken.class);
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
