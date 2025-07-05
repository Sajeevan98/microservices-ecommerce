package com.project.sajee.order.service.imp;

import com.project.sajee.order.client.InventoryClient;
import com.project.sajee.order.dto.OrderRequest;
import com.project.sajee.order.exception.ProductOutOfStockException;
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
    private final InventoryClient inventoryClient;

    @Override
    public Order placeOrder(OrderRequest order) {
        if (order != null) {
            var response = inventoryClient.isStock(order.code(), order.quantity());
            if (response) {
                // map OrderRequest into OrderObject
                Order orderObj = new Order();
                orderObj.setOrderNumber(UUID.randomUUID().toString());
                orderObj.setCode(order.code());
                orderObj.setPrice(order.price());
                orderObj.setQuantity(order.quantity());

                // save Order into OrderRepository
                orderRepository.save(orderObj);
                return orderObj;
            }
            else {
                throw new ProductOutOfStockException("Product exists with code '"+order.code()+ "' not in stock!");
            }
        }
        return null;
    }


}
