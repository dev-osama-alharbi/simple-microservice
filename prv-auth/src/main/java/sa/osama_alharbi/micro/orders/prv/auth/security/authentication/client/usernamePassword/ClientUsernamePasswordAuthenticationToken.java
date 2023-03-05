package sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.usernamePassword;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.ClientPrincipal;

import java.util.ArrayList;

public class ClientUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public ClientUsernamePasswordAuthenticationToken(ClientPrincipal clientPrincipal, String password) {
        super(clientPrincipal, password);
    }
    public ClientUsernamePasswordAuthenticationToken(String username, String password) {
        super(new ClientPrincipal(username,password,new ArrayList<>()), password);
    }
}
