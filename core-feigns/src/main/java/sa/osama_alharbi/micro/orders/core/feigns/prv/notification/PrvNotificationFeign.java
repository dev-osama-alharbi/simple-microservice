package sa.osama_alharbi.micro.orders.core.feigns.prv.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sa.osama_alharbi.micro.orders.core.db.entity.PaymentEntity;

@FeignClient(name = "prv-notification", url = "http://${service.host.prv.notification}/prv/notification")
public interface PrvNotificationFeign {

    @PostMapping("/email/sendBill")
    ResponseEntity<PaymentEntity> sendBillViaEmail(@RequestBody() PaymentEntity paymentEntity);
}
