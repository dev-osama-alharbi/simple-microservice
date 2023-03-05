package sa.osama_alharbi.micro.orders.core.db.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @Column(nullable = false,name = "id",columnDefinition = "integer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,name = "datetime",columnDefinition = "DATETIME")
    @CreationTimestamp
    private LocalDateTime datetime;
    @Column(nullable = false,name = "quantity",columnDefinition = "integer")
    private Integer quantity;
    @Column(nullable = false,name = "price",columnDefinition = "DECIMAL(10,2)")
    private Double price;
    @Column(nullable = false,name = "client_id",insertable = true,updatable = true,columnDefinition = "integer")
    private Integer client_id;
    @Column(nullable = false,name = "order_id",insertable = true,updatable = true,columnDefinition = "integer")
    private Integer order_id;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne()
    @JoinColumn(
            name = "client_id",
            referencedColumnName = "id",
            insertable = false,
            updatable = false
    )
    private ClientEntity clientEntity;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne()
    @JoinColumn(
            name = "order_id",
            referencedColumnName = "id",
            insertable = false,
            updatable = false
    )
    private OrderEntity orderEntity;
}
