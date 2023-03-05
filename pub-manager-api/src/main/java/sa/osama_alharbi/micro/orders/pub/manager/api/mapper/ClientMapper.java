package sa.osama_alharbi.micro.orders.pub.manager.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;
import sa.osama_alharbi.micro.orders.pub.manager.api.dto.AddEditClientDTO;
import sa.osama_alharbi.micro.orders.pub.manager.api.dto.ClientInfoDTO;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    @Mappings({
            @Mapping(target = "isAdmin",source = "is_admin"),
            @Mapping(target = "phoneNumber", source = "phone_number")
    })
    ClientEntity toEntity(AddEditClientDTO dto);


    @Mappings({
            @Mapping(target = "is_admin",source = "isAdmin"),
            @Mapping(target = "phone_number", source = "phoneNumber")
    })
    ClientInfoDTO toClientInfoDTO(ClientEntity entity);

    List<ClientEntity> toEntity(List<AddEditClientDTO> lst);

    List<ClientInfoDTO> toClientInfoDTO(List<ClientEntity> lst);
}
