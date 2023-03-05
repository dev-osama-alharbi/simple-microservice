package sa.osama_alharbi.micro.orders.pub.orders.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.osama_alharbi.micro.orders.core.db.dto.BillDTO;
import sa.osama_alharbi.micro.orders.core.feigns.prv.orders.PrvOrdersFeign;
import sa.osama_alharbi.micro.orders.core.feigns.prv.payment.PrvPaymentFeign;
import sa.osama_alharbi.micro.orders.pub.orders.api.dto.OrderInfoDTO;
import sa.osama_alharbi.micro.orders.pub.orders.api.dto.PaymentRequestDTO;
import sa.osama_alharbi.micro.orders.pub.orders.api.mapper.OrderMapper;
import sa.osama_alharbi.micro.orders.pub.orders.api.mapper.PaymentMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders/pay")
@RequiredArgsConstructor
@Slf4j
public class PayController {

    private final PrvPaymentFeign prvPayment;
    private final PaymentMapper paymentMapper;

    @Operation(summary = "getById")
    @PostMapping("/{order_id}")
    public ResponseEntity<BillDTO> getById(@PathVariable("order_id") Integer order_id, @RequestBody PaymentRequestDTO paymentRequestDTO){
        //TODO get client_id
        int client_id = 1;
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(prvPayment.pay(paymentMapper.toNewPaymentDTO(paymentRequestDTO,client_id,order_id)).getBody());
    }
}
