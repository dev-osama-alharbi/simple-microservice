package sa.osama_alharbi.micro.orders.prv.client.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<ClientEntity, Integer> {
    @Transactional
    @Modifying
    @Query("update ClientEntity c set c.isDelete = true where c.id = ?1")
    int updateIsDeleteTrueById(Integer id);
    List<ClientEntity> findAllByIsDeleteFalse();

    Optional<ClientEntity> findByIdAndIsDeleteFalse(Integer id);
}