package sa.osama_alharbi.micro.orders.pub.client.api.controller;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.osama_alharbi.micro.orders.core.feigns.prv.client.PrvClientFeign;
import sa.osama_alharbi.micro.orders.pub.client.api.dto.AddEditClientDTO;
import sa.osama_alharbi.micro.orders.pub.client.api.dto.ClientInfoDTO;
import sa.osama_alharbi.micro.orders.pub.client.api.dto.ResultDTO;
import sa.osama_alharbi.micro.orders.pub.client.api.mapper.ClientMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final PrvClientFeign prvClient;
    private final ClientMapper clientMapper;

    @Operation(summary = "getMe")
    @GetMapping("/me")
    public ResponseEntity<ClientInfoDTO> getMe(){
        return ResponseEntity.status(HttpStatus.OK).body(clientMapper.toClientInfoDTO(prvClient.getById(1).getBody()));
    }

}
