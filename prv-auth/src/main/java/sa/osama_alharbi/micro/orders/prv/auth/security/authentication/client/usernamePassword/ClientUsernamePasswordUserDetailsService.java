package sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.usernamePassword;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.ClientPrincipal;
import sa.osama_alharbi.micro.orders.prv.auth.service.LoginService;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class ClientUsernamePasswordUserDetailsService implements UserDetailsService {
    private final LoginService loginService;

    @Override
    public ClientPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        ClientEntity client = loginService.loadClientByUsername(username);

        ClientPrincipal clientPrincipal = new ClientPrincipal(client.getUsername(),client.getPassword(), Arrays.asList());
        clientPrincipal.setClient(client);

        return clientPrincipal;
    }
}
