package sa.osama_alharbi.micro.orders.prv.client.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;
import sa.osama_alharbi.micro.orders.prv.client.service.ClientService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/prv/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{client_id}")
    public ResponseEntity<ClientEntity> getById(@PathVariable("client_id") Integer client_id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientService.getById(client_id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientEntity>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<ClientEntity> addNewClient(@RequestBody ClientEntity clientEntity){
        log.info("start addNewClient from api");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientService.add(clientEntity));
    }

    @PutMapping("/{client_id}")
    public ResponseEntity<ClientEntity> editClient(@PathVariable("client_id") Integer client_id,@RequestBody ClientEntity clientEntity){
        clientEntity.setId(client_id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientService.edit(clientEntity));
    }
    @DeleteMapping("/{client_id}")
    public ResponseEntity<Boolean> deleteClient(@PathVariable("client_id") Integer client_id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientService.deleteClient(client_id));
    }
}
