package com.project.sajee.order.service;

import com.project.sajee.order.dto.OrderRequest;
import com.project.sajee.order.model.Order;

public interface OrderService {
    Order placeOrder(OrderRequest order);

}
