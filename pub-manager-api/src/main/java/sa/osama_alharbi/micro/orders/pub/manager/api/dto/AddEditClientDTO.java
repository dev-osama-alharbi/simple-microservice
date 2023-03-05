package sa.osama_alharbi.micro.orders.pub.manager.api.dto;


import lombok.Data;

@Data
public class AddEditClientDTO {
    private String username;
    private String password;
    private String email;
    private String phone_number;
    private Double price;
    private Boolean is_admin;
}
