package sa.osama_alharbi.micro.orders.prv.auth.security.authentication.manager.emailPassword;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.manager.ManagerPrincipal;

import java.util.ArrayList;

public class ManagerEmailPasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public ManagerEmailPasswordAuthenticationToken(ManagerPrincipal managerPrincipal, String password) {
        super(managerPrincipal, password);
    }
    public ManagerEmailPasswordAuthenticationToken(String email, String password) {
        super(new ManagerPrincipal(email,password,new ArrayList<>()), password);
    }
}
