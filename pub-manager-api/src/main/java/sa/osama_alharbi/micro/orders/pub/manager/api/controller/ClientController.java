package sa.osama_alharbi.micro.orders.pub.manager.api.controller;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.osama_alharbi.micro.orders.core.feigns.prv.client.PrvClientFeign;
import sa.osama_alharbi.micro.orders.pub.manager.api.dto.AddEditClientDTO;
import sa.osama_alharbi.micro.orders.pub.manager.api.dto.ClientInfoDTO;
import sa.osama_alharbi.micro.orders.pub.manager.api.dto.ResultDTO;
import sa.osama_alharbi.micro.orders.pub.manager.api.mapper.ClientMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manager/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final PrvClientFeign prvClient;
    private final ClientMapper clientMapper;

    @Operation(summary = "getById")
    @GetMapping("/{client_id}")
    public ResponseEntity<ClientInfoDTO> getById(@PathVariable("client_id") Integer client_id){
        return ResponseEntity.status(HttpStatus.OK).body(clientMapper.toClientInfoDTO(prvClient.getById(client_id).getBody()));
    }

    @Operation(summary = "getAll")
    @GetMapping("/all")
    public ResponseEntity<List<ClientInfoDTO>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientMapper.toClientInfoDTO(prvClient.getAll().getBody()));
    }

    @Operation(summary = "addNewClient")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200",description = "client added"),
//            @ApiResponse(responseCode = "403",description = "some items is missing"),
//            @ApiResponse(responseCode = "401",description = "UNAUTHORIZED"),
//    })
    @PostMapping(value = "")
    public ResponseEntity<ClientInfoDTO> addNewClient(@RequestBody AddEditClientDTO addNewClientDTO){
        log.info("start addNewClient from pub-client-api");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientMapper.toClientInfoDTO(prvClient.addNewClient(clientMapper.toEntity(addNewClientDTO)).getBody()));
    }


    @Operation(summary = "editClient")
    @PutMapping("/{client_id}")
    public ResponseEntity<ClientInfoDTO> editClient(@PathVariable("client_id") Integer client_id,@RequestBody AddEditClientDTO addNewClientDTO){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientMapper.toClientInfoDTO(prvClient.editClient(client_id,clientMapper.toEntity(addNewClientDTO)).getBody()));
    }

    @Operation(summary = "deleteClient")
    @DeleteMapping("/{client_id}")
    public ResponseEntity<ResultDTO<Boolean>> deleteClient(@PathVariable("client_id") Integer client_id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResultDTO.<Boolean>builder().result(prvClient.deleteClient(client_id).getBody()).build());
    }
}
