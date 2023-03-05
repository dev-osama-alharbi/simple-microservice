package sa.osama_alharbi.micro.orders.prv.orders.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sa.osama_alharbi.micro.orders.core.db.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {
    @Transactional
    @Modifying
    @Query("update OrderEntity c set c.isDelete = true where c.id = ?1")
    int updateIsDeleteTrueById(Integer id);
    Optional<OrderEntity> findByIdAndIsDeleteFalse(Integer orderId);

    List<OrderEntity> findAllByIsDeleteFalse();
}