package sa.osama_alharbi.micro.orders.pub.manager.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import sa.osama_alharbi.micro.orders.core.db.entity.OrderEntity;
import sa.osama_alharbi.micro.orders.pub.manager.api.dto.AddEditOrderDTO;
import sa.osama_alharbi.micro.orders.pub.manager.api.dto.OrderInfoDTO;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderEntity toEntity(AddEditOrderDTO dto);

    OrderInfoDTO toOrderInfoDTO(OrderEntity entity);

    List<OrderEntity> toEntity(List<AddEditOrderDTO> lst);

    List<OrderInfoDTO> toOrderInfoDTO(List<OrderEntity> lst);
}
