package com.project.sajee.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class GatewayFallbackController {

    @PostMapping("/product")
    public ResponseEntity<String> saveProductFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Product Service is temporarily unavailable. Please try again later!");
    }
    @GetMapping("/product")
    public ResponseEntity<String> getProductFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Product Service is temporarily unavailable. Please try again later!");
    }

    @PostMapping("/order")
    public ResponseEntity<String> orderFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Order Service is down. Please try again later!");
    }

    @GetMapping("/inventory")
    public ResponseEntity<String> inventoryFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Inventory Service is not responding. Try again later!");
    }
}
