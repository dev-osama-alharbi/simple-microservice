package sa.osama_alharbi.micro.orders.prv.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<ClientEntity, Integer> {
    Optional<ClientEntity> findByPhoneNumber(String phoneNumber);
    Optional<ClientEntity> findByEmail(String email);
    Optional<ClientEntity> findByUsername(String username);
}