package sa.osama_alharbi.micro.orders.core.db.dto;

import lombok.Data;

@Data
public class NewPaymentDTO {
    private Integer quantity;
    private Integer order_id;
    private Integer client_id;
}
