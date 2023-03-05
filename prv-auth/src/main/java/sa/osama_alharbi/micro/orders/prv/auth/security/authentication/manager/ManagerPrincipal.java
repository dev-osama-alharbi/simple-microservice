package sa.osama_alharbi.micro.orders.prv.auth.security.authentication.manager;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;

import java.util.List;

@Setter
@Getter
public class ManagerPrincipal extends User {
    private Integer id = null;
    private String username = null;
    private String password = null;
    private ClientEntity client = null;

    public ManagerPrincipal(String username, String password, List<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.username = username;
        this.password = password;
    }


}
