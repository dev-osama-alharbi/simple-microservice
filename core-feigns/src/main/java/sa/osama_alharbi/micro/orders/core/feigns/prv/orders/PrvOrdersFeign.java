package sa.osama_alharbi.micro.orders.core.feigns.prv.orders;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;
import sa.osama_alharbi.micro.orders.core.db.entity.OrderEntity;

import java.util.List;

@FeignClient(name = "prv-order", url = "http://${service.host.prv.order}/prv/order")
public interface PrvOrdersFeign {

    @GetMapping("/{order_id}")
    ResponseEntity<OrderEntity> getById(@PathVariable("order_id") Integer order_id);
    @GetMapping("/all")
    ResponseEntity<List<OrderEntity>> getAll();
    @PostMapping("")
    ResponseEntity<OrderEntity> addNewClient(@RequestBody OrderEntity orderEntity);
    @PutMapping("/{order_id}")
    ResponseEntity<OrderEntity> editClient(@PathVariable("order_id") Integer order_id,@RequestBody OrderEntity orderEntity);
    @DeleteMapping("/{order_id}")
    ResponseEntity<Boolean> deleteClient(@PathVariable("order_id") Integer order_id);
}
