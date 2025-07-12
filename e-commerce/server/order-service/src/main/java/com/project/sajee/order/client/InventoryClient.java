package com.project.sajee.order.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface InventoryClient {

    @GetExchange("/api/v1.0/inventory")
    boolean isStock(@RequestParam String code, @RequestParam Integer quantity);
}
