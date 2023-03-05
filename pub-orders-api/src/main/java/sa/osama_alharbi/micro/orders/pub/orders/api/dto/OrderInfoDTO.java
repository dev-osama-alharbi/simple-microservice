package sa.osama_alharbi.micro.orders.pub.orders.api.dto;

import lombok.Data;

@Data
public class OrderInfoDTO {
    private Integer id;
    private String title;
    private Integer quantity;
    private Double price;
}
