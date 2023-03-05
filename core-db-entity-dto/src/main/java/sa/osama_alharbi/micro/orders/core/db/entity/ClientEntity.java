package sa.osama_alharbi.micro.orders.core.db.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "client")
public class ClientEntity {
    @Id
    @Column(nullable = false,name = "id",columnDefinition = "integer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,name = "username",columnDefinition = "varchar(255)")
    private String username;
    @Column(nullable = false,name = "password",columnDefinition = "varchar(255)")
    private String password;
    @Column(nullable = false,name = "email",columnDefinition = "varchar(255)")
    private String email;
    @Column(nullable = false,name = "phone_number",columnDefinition = "varchar(255)")
    private String phoneNumber;

    @Column(nullable = false,name = "price",columnDefinition = "DECIMAL(10,2)")
    private Double price;
    @Column(nullable = false,name = "is_admin",columnDefinition = "bit")
    private Boolean isAdmin;
    @Column(nullable = false,name = "is_delete",columnDefinition = "bit")
    private Boolean isDelete;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "client_id",
            referencedColumnName = "id"
    )
    private List<PaymentEntity> paymentEntityList;
}
