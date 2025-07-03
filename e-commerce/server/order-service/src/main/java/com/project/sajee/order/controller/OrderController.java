package com.project.sajee.order.controller;

import com.project.sajee.order.dto.OrderRequest;
import com.project.sajee.order.dto.OrderResponse;
import com.project.sajee.order.model.Order;
import com.project.sajee.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1.0/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request){
        Order result = orderService.placeOrder(request);
        if (result != null){
            OrderResponse response = new OrderResponse("order placed successfully!", result);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        else{
            OrderResponse response = new OrderResponse("could not placed the order! try again...", null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
