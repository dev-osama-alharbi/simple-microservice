package sa.osama_alharbi.micro.orders.prv.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;
import sa.osama_alharbi.micro.orders.prv.auth.repo.ClientRepo;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final ClientRepo clientRepo;

    public ClientEntity loadClientByUsername(String username) {
        return clientRepo.findByUsername(username).orElse(null);
    }

    public ClientEntity loadClientByEmail(String email) {
        return clientRepo.findByEmail(email).orElse(null);
    }

    public ClientEntity loadClientByPhoneNumber(String phoneNumber) {
        return clientRepo.findByPhoneNumber(phoneNumber).orElse(null);
    }
}
