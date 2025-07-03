package com.project.sajee.order.service.imp;

import com.project.sajee.order.dto.OrderRequest;
import com.project.sajee.order.model.Order;
import com.project.sajee.order.repository.OrderRepository;
import com.project.sajee.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order placeOrder(OrderRequest order) {
        if (order != null){
            // map OrderRequest into OrderObject
            Order orderObj = new Order();
            orderObj.setOrderNumber(UUID.randomUUID().toString());
            orderObj.setCode(order.code());
            orderObj.setTotalPrice(order.totalPrice());
            orderObj.setQuantity(order.quantity());

            // save Order into OrderRepository
            orderRepository.save(orderObj);
            log.info("order placed successfully!");
            return orderObj;
        }
        log.info("something went wrong! could not placed the order.");
        return null;
    }


}
