package sa.osama_alharbi.micro.orders.core.feigns.prv.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;

import java.util.List;

//@FeignClient(value = "prv-client",contextId = "app" ,path = "/prv/member")
@FeignClient(name = "prv-client", url = "http://${service.host.prv.client}/prv/client")
public interface PrvClientFeign {

    @GetMapping("/{client_id}")
    ResponseEntity<ClientEntity> getById(@PathVariable("client_id") Integer client_id);
    @GetMapping("/all")
    ResponseEntity<List<ClientEntity>> getAll();
    @PostMapping("")
    ResponseEntity<ClientEntity> addNewClient(@RequestBody ClientEntity clientEntity);
    @PutMapping("/{client_id}")
    ResponseEntity<ClientEntity> editClient(@PathVariable("client_id") Integer client_id,@RequestBody ClientEntity clientEntity);
    @DeleteMapping("/{client_id}")
    ResponseEntity<Boolean> deleteClient(@PathVariable("client_id") Integer client_id);
}
