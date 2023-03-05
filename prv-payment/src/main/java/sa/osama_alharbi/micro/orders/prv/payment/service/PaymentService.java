package sa.osama_alharbi.micro.orders.prv.payment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sa.osama_alharbi.micro.orders.core.db.dto.BillDTO;
import sa.osama_alharbi.micro.orders.core.db.dto.NewPaymentDTO;
import sa.osama_alharbi.micro.orders.core.db.entity.ClientEntity;
import sa.osama_alharbi.micro.orders.core.db.entity.OrderEntity;
import sa.osama_alharbi.micro.orders.core.db.entity.PaymentEntity;
import sa.osama_alharbi.micro.orders.core.db.exception.DB_Select_NotFound_Exception;
import sa.osama_alharbi.micro.orders.core.db.mapper.BillMapper;
import sa.osama_alharbi.micro.orders.prv.payment.repo.ClientRepo;
import sa.osama_alharbi.micro.orders.prv.payment.repo.OrderRepo;
import sa.osama_alharbi.micro.orders.prv.payment.repo.PaymentRepo;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final ClientRepo clientRepo;
    private final OrderRepo orderRepo;
    private final PaymentRepo paymentRepo;
    private final BillMapper billMapper;

    @Transactional
    public BillDTO pay(NewPaymentDTO newPaymentDTO) {
        ClientEntity client = clientRepo
                .findByIdAndIsDeleteFalse(newPaymentDTO.getClient_id())
                .orElseThrow(() -> new DB_Select_NotFound_Exception("[client] id = "+newPaymentDTO.getClient_id()+" Not found"));

        OrderEntity order = orderRepo
                .findByIdAndIsDeleteFalse(newPaymentDTO.getOrder_id())
                .orElseThrow(() -> new DB_Select_NotFound_Exception("[order] id = "+newPaymentDTO.getOrder_id()+" Not found"));


        if(order.getQuantity() < newPaymentDTO.getQuantity()){
            //TODO threw out of stuck
        }
        double paymentSum = order.getPrice() * newPaymentDTO.getQuantity();
        if(client.getPrice().doubleValue() < paymentSum){
            //TODO threw client does have money
        }

        client.setPrice(client.getPrice() - paymentSum);
        clientRepo.save(client);

        order.setQuantity(order.getQuantity() - newPaymentDTO.getQuantity());
        orderRepo.save(order);

        PaymentEntity paymentEntity = PaymentEntity
                .builder()
                .quantity(newPaymentDTO.getQuantity())
                .price(paymentSum)
                .client_id(client.getId())
                .order_id(order.getId())
                .build();

        return billMapper.toBill(client,order,paymentRepo.save(paymentEntity));
    }
}
