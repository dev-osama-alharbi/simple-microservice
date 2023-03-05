package sa.osama_alharbi.micro.orders.prv.notification.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.osama_alharbi.micro.orders.core.db.dto.EmailNotificationDTO;
import sa.osama_alharbi.micro.orders.core.db.entity.OrderEntity;


@RestController
@RequestMapping("/prv/notification/email")
@RequiredArgsConstructor
@Slf4j
public class EmailNotificationController {

    @PostMapping("/sendBill")
    public void getById(@RequestBody() EmailNotificationDTO emailNotificationDTO){

    }
}
