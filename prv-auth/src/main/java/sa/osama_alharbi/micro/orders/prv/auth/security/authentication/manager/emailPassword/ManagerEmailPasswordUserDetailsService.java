package sa.osama_alharbi.micro.orders.prv.auth.security.authentication.manager.emailPassword;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.ClientPrincipal;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.manager.ManagerPrincipal;
import sa.osama_alharbi.micro.orders.prv.auth.service.LoginService;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class ManagerEmailPasswordUserDetailsService implements UserDetailsService {
    private final LoginService loginService;

    @Override
    public ManagerPrincipal loadUserByUsername(String email) throws UsernameNotFoundException {
        ClientEntity client = loginService.loadClientByEmail(email);

        ManagerPrincipal managerPrincipal = new ManagerPrincipal(client.getEmail(),client.getPassword(), Arrays.asList());
        managerPrincipal.setClient(client);

        return managerPrincipal;
    }
}
