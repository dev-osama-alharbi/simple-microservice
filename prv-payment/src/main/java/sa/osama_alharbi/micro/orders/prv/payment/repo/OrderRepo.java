package sa.osama_alharbi.micro.orders.prv.payment.repo;

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
    Optional<OrderEntity> findByIdAndIsDeleteFalse(Integer orderId);
}