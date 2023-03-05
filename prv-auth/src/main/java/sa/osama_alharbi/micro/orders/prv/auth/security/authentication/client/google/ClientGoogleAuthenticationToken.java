package sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.google;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.ClientPrincipal;

import java.util.ArrayList;

public class ClientGoogleAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public ClientGoogleAuthenticationToken(ClientPrincipal clientPrincipal, String password) {
        super(clientPrincipal, password);
    }
    public ClientGoogleAuthenticationToken(String email) {
        super(new ClientPrincipal(email,new ArrayList<>()),"");
    }
}
