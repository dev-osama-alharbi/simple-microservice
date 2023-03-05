package sa.osama_alharbi.micro.orders.prv.auth.security.authentication.manager.phoneNumberPassword;

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
public class ManagerPhoneNumberPasswordUserDetailsService implements UserDetailsService {
    private final LoginService loginService;

    @Override
    public ManagerPrincipal loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        ClientEntity client = loginService.loadClientByPhoneNumber(phoneNumber);

        ManagerPrincipal managerPrincipal = new ManagerPrincipal(client.getPhoneNumber(),client.getPassword(), Arrays.asList());
        managerPrincipal.setClient(client);

        return managerPrincipal;
    }
}
