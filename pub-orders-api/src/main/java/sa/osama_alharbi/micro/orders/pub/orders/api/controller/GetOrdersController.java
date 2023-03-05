package sa.osama_alharbi.micro.orders.pub.orders.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.osama_alharbi.micro.orders.core.feigns.prv.orders.PrvOrdersFeign;
import sa.osama_alharbi.micro.orders.pub.orders.api.dto.OrderInfoDTO;
import sa.osama_alharbi.micro.orders.pub.orders.api.mapper.OrderMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders/get")
@RequiredArgsConstructor
@Slf4j
public class GetOrdersController {

    private final PrvOrdersFeign prvOrders;
    private final OrderMapper orderMapper;


    @Operation(summary = "getById")
    @GetMapping("/{order_id}")
    public ResponseEntity<OrderInfoDTO> getById(@PathVariable("order_id") Integer order_id){
        return ResponseEntity.status(HttpStatus.OK).body(orderMapper.toOrderInfoDTO(prvOrders.getById(order_id).getBody()));
    }

    @Operation(summary = "getAll")
    @GetMapping("/all")
    public ResponseEntity<List<OrderInfoDTO>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderMapper.toOrderInfoDTO(prvOrders.getAll().getBody()));
    }
}
