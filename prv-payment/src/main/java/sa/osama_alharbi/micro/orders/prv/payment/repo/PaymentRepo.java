package sa.osama_alharbi.micro.orders.prv.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sa.osama_alharbi.micro.orders.core.db.entity.PaymentEntity;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentEntity, Integer> {
}