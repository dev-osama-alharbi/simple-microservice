package sa.osama_alharbi.micro.orders.pub.client.api.dto;


import lombok.Data;

@Data
public class ClientInfoDTO {
    private Integer id;
    private String username;
    private String email;
    private String phone_number;
    private Double price;
    private Boolean is_admin;
}
