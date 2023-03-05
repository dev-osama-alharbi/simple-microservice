package sa.osama_alharbi.micro.orders.core.db.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BillDTO {
    private Integer bill_id;
    private LocalDateTime bill_datetime;
    private Integer bill_quantity;
    private Double bill_price;
    private Integer client_id;
    private String client_username;
    private String client_email;
    private Integer order_id;
    private String order_name;
    private String order_price;

}
