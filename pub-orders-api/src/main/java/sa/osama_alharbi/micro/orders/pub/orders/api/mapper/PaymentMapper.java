package sa.osama_alharbi.micro.orders.pub.orders.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import sa.osama_alharbi.micro.orders.core.db.dto.NewPaymentDTO;
import sa.osama_alharbi.micro.orders.pub.orders.api.dto.PaymentRequestDTO;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentMapper {

    NewPaymentDTO toNewPaymentDTO(PaymentRequestDTO dto,int client_id,int order_id);

    PaymentRequestDTO toPaymentRequestDTO(NewPaymentDTO newPaymentDTO);

    List<NewPaymentDTO> toNewPaymentDTO(List<PaymentRequestDTO> lst);

    List<PaymentRequestDTO> toPaymentRequestDTO(List<NewPaymentDTO> lst);
}
