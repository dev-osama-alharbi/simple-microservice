package sa.osama_alharbi.micro.orders.prv.auth.security.authentication.manager.phoneNumberPassword;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.manager.ManagerPrincipal;

import java.util.ArrayList;

public class ManagerPhoneNumberPasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public ManagerPhoneNumberPasswordAuthenticationToken(ManagerPrincipal managerPrincipal, String password) {
        super(managerPrincipal, password);
    }
    public ManagerPhoneNumberPasswordAuthenticationToken(String phoneNumber, String password) {
        super(new ManagerPrincipal(phoneNumber,password,new ArrayList<>()), password);
    }
}
