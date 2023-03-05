package sa.osama_alharbi.micro.orders.core.db.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import sa.osama_alharbi.micro.orders.core.db.dto.BillDTO;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;
import sa.osama_alharbi.micro.orders.core.db.entity.OrderEntity;
import sa.osama_alharbi.micro.orders.core.db.entity.PaymentEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BillMapper {

    @Mappings({
            @Mapping(target = "client_id", source = "clientEntity.id"),
            @Mapping(target = "client_username", source = "clientEntity.username"),
            @Mapping(target = "client_email", source = "clientEntity.email"),
            @Mapping(target = "order_id",source = "orderEntity.id"),
            @Mapping(target = "order_name",source = "orderEntity.title"),
            @Mapping(target = "order_price",source = "orderEntity.price"),
            @Mapping(target = "bill_id",source = "paymentEntity.id"),
            @Mapping(target = "bill_datetime",source = "paymentEntity.datetime"),
            @Mapping(target = "bill_quantity",source = "paymentEntity.quantity"),
            @Mapping(target = "bill_price",source = "paymentEntity.price"),
    })
    BillDTO toBill(ClientEntity clientEntity, OrderEntity orderEntity, PaymentEntity paymentEntity);
}
