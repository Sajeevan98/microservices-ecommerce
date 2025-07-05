package com.project.sajee.inventory.repository;

import com.project.sajee.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    boolean existsByCodeAndQuantityIsGreaterThanEqual(String code, Integer quantity);
}
