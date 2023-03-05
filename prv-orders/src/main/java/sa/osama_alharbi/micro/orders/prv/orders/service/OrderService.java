package sa.osama_alharbi.micro.orders.prv.orders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sa.osama_alharbi.micro.orders.core.db.entity.OrderEntity;
import sa.osama_alharbi.micro.orders.core.db.exception.DB_Column_Error_Exception;
import sa.osama_alharbi.micro.orders.core.db.exception.DB_Column_Missing_Exception;
import sa.osama_alharbi.micro.orders.core.db.exception.DB_Select_ListEmpty_Exception;
import sa.osama_alharbi.micro.orders.core.db.exception.DB_Select_NotFound_Exception;
import sa.osama_alharbi.micro.orders.prv.orders.repo.OrderRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;

    public OrderEntity getById(Integer orderId) {
        return orderRepo
                .findByIdAndIsDeleteFalse(orderId)
                .orElseThrow(() -> new DB_Select_NotFound_Exception());
    }

    public List<OrderEntity> getAll() {
        List<OrderEntity> lst = orderRepo.findAllByIsDeleteFalse();
        if(lst.isEmpty()){
            throw new DB_Select_ListEmpty_Exception();
        }else{
            return lst;
        }
    }

    public OrderEntity add(OrderEntity orderEntity) {
        if(orderEntity.getId() != null){
            throw new DB_Column_Error_Exception("[order] [id] id must be null");
        }
        orderEntity.setIsDelete(false);
        return orderRepo.save(orderEntity);
    }

    public OrderEntity edit(OrderEntity orderEntity) {
        if(orderEntity.getId() == null){
            throw new DB_Column_Missing_Exception("[order] [id] id must be defined");
        }
        orderRepo
                .findByIdAndIsDeleteFalse(orderEntity.getId())
                .orElseThrow(() ->new DB_Select_NotFound_Exception());

        orderEntity.setIsDelete(false);
        return orderRepo.save(orderEntity);
    }

    public Boolean delete(Integer clientId) {
        orderRepo
                .findByIdAndIsDeleteFalse(clientId)
                .orElseThrow(() ->new DB_Select_NotFound_Exception());
        return orderRepo.updateIsDeleteTrueById(clientId) >= 1;
    }
}
