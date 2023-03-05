package sa.osama_alharbi.micro.orders.pub.manager.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.osama_alharbi.micro.orders.core.feigns.prv.orders.PrvOrdersFeign;
import sa.osama_alharbi.micro.orders.pub.manager.api.dto.AddEditOrderDTO;
import sa.osama_alharbi.micro.orders.pub.manager.api.dto.OrderInfoDTO;
import sa.osama_alharbi.micro.orders.pub.manager.api.dto.ResultDTO;
import sa.osama_alharbi.micro.orders.pub.manager.api.mapper.OrderMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manager/orders")
@RequiredArgsConstructor
@Slf4j
public class OrdersController {

    private final PrvOrdersFeign prvOrders;
    private final OrderMapper orderMapper;

    @Operation(summary = "addNewOrder")
    @PostMapping(value = "")
    public ResponseEntity<OrderInfoDTO> addNewOrder(@RequestBody AddEditOrderDTO addEditOrderDTO){
        log.info("start addNewOrder from pub-client-api");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderMapper.toOrderInfoDTO(prvOrders.addNewClient(orderMapper.toEntity(addEditOrderDTO)).getBody()));
    }


    @Operation(summary = "editClient")
    @PutMapping("/{order_id}")
    public ResponseEntity<OrderInfoDTO> editClient(@PathVariable("order_id") Integer order_id,@RequestBody AddEditOrderDTO addEditOrderDTO){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderMapper.toOrderInfoDTO(prvOrders.editClient(order_id,orderMapper.toEntity(addEditOrderDTO)).getBody()));
    }

    @Operation(summary = "deleteOrder")
    @DeleteMapping("/{order_id}")
    public ResponseEntity<ResultDTO<Boolean>> deleteOrder(@PathVariable("order_id") Integer order_id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResultDTO.<Boolean>builder().result(prvOrders.deleteClient(order_id).getBody()).build());
    }
}
