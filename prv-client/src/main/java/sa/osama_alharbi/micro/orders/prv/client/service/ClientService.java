package sa.osama_alharbi.micro.orders.prv.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;
import sa.osama_alharbi.micro.orders.core.db.exception.DB_Column_Error_Exception;
import sa.osama_alharbi.micro.orders.core.db.exception.DB_Column_Missing_Exception;
import sa.osama_alharbi.micro.orders.core.db.exception.DB_Select_ListEmpty_Exception;
import sa.osama_alharbi.micro.orders.core.db.exception.DB_Select_NotFound_Exception;
import sa.osama_alharbi.micro.orders.prv.client.repo.ClientRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepo clientRepo;


    public ClientEntity getById(Integer clientId) {
        return clientRepo
                .findByIdAndIsDeleteFalse(clientId)
                .orElseThrow(() ->new DB_Select_NotFound_Exception());
    }

    public List<ClientEntity> getAll() {
        List<ClientEntity> lst = clientRepo.findAllByIsDeleteFalse();
        if(lst.isEmpty()){
            throw new DB_Select_ListEmpty_Exception();
        }else{
            return lst;
        }
    }

    public ClientEntity add(ClientEntity clientEntity) {
        if(clientEntity.getId() != null){
            throw new DB_Column_Error_Exception("[client] [id] id must be null");
        }
        clientEntity.setIsDelete(false);
        return clientRepo.save(clientEntity);
    }

    public ClientEntity edit(ClientEntity clientEntity) {
        if(clientEntity.getId() == null){
            throw new DB_Column_Missing_Exception("[client] [id] id must be defined");
        }
        clientRepo
                .findByIdAndIsDeleteFalse(clientEntity.getId())
                .orElseThrow(() ->new DB_Select_NotFound_Exception());

        clientEntity.setIsDelete(false);
        return clientRepo.save(clientEntity);
    }

    public Boolean deleteClient(Integer clientId) {
        clientRepo
                .findByIdAndIsDeleteFalse(clientId)
                .orElseThrow(() ->new DB_Select_NotFound_Exception());
        return clientRepo.updateIsDeleteTrueById(clientId) >= 1;
    }
}
