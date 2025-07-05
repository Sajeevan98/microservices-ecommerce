package com.project.sajee.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory", url = "${spring.inventory.client.url}")
public interface InventoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1.0/inventory")
    boolean isStock(@RequestParam String code, @RequestParam Integer quantity);
}
