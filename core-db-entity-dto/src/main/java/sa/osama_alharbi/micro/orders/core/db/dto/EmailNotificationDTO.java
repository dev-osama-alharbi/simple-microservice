package sa.osama_alharbi.micro.orders.core.db.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;
import sa.osama_alharbi.micro.orders.core.db.entity.OrderEntity;
import sa.osama_alharbi.micro.orders.core.db.entity.PaymentEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailNotificationDTO {
    private ClientEntity client;
    private OrderEntity order;
    private PaymentEntity payment;
}
