package sa.osama_alharbi.micro.orders.prv.payment.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sa.osama_alharbi.micro.orders.core.db.dto.BillDTO;
import sa.osama_alharbi.micro.orders.core.db.dto.NewPaymentDTO;
import sa.osama_alharbi.micro.orders.prv.payment.service.PaymentService;


@RestController
@RequestMapping("/prv/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("")
    public ResponseEntity<BillDTO> pay(@RequestBody() NewPaymentDTO newPaymentDTO){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paymentService.pay(newPaymentDTO));
    }
}
