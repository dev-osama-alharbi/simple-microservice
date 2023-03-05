package sa.osama_alharbi.micro.orders.core.feigns.prv.payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.osama_alharbi.micro.orders.core.db.dto.BillDTO;
import sa.osama_alharbi.micro.orders.core.db.dto.NewPaymentDTO;
import sa.osama_alharbi.micro.orders.core.db.entity.OrderEntity;
import sa.osama_alharbi.micro.orders.core.db.entity.PaymentEntity;

import java.util.List;

@FeignClient(name = "prv-payment", url = "http://${service.host.prv.payment}/prv/payment")
public interface PrvPaymentFeign {

    @PostMapping("")
    ResponseEntity<BillDTO> pay(@RequestBody() NewPaymentDTO newPaymentDTO);
}
