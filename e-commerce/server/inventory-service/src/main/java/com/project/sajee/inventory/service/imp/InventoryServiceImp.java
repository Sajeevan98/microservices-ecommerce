package com.project.sajee.inventory.service.imp;

import com.project.sajee.inventory.repository.InventoryRepository;
import com.project.sajee.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceImp implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public boolean isStock(String code, Integer quantity) {
        return inventoryRepository.existsByCodeAndQuantityIsGreaterThanEquals(code, quantity);
    }

}
