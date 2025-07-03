package com.project.sajee.order.dto;

import com.project.sajee.order.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {
    private String message;
    private Order order;
}
