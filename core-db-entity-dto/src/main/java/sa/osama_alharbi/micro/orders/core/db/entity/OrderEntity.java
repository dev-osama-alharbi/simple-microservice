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
@Table(name = "orders")
public class OrderEntity {
    @Id
    @Column(nullable = false,name = "id",columnDefinition = "integer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,name = "title",columnDefinition = "varchar(255)")
    private String title;

    @Column(nullable = false,name = "quantity",columnDefinition = "integer")
    private Integer quantity;

    @Column(nullable = false,name = "price",columnDefinition = "DECIMAL(10,2)")
    private Double price;
    @Column(nullable = false,name = "is_delete",columnDefinition = "bit")
    private Boolean isDelete;


    @JsonIgnore
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "order_id",
            referencedColumnName = "id"
    )
    private List<PaymentEntity> paymentEntityList;
}
