package sa.osama_alharbi.micro.orders.prv.orders.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;
import sa.osama_alharbi.micro.orders.core.db.entity.OrderEntity;
import sa.osama_alharbi.micro.orders.prv.orders.service.OrderService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/prv/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{order_id}")
    public ResponseEntity<OrderEntity> getById(@PathVariable("order_id") Integer order_id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.getById(order_id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderEntity>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<OrderEntity> addNewOrder(@RequestBody OrderEntity orderEntity){
        log.info("start addNewClient from api");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.add(orderEntity));
    }

    @PutMapping("/{order_id}")
    public ResponseEntity<OrderEntity> editOrder(@PathVariable("order_id") Integer order_id,@RequestBody OrderEntity orderEntity){
        orderEntity.setId(order_id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.edit(orderEntity));
    }
    @DeleteMapping("/{order_id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable("order_id") Integer order_id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.delete(order_id));
    }
}
