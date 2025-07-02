package com.project.sajee.product.service;

import com.project.sajee.product.dto.ProductRequest;
import com.project.sajee.product.model.Product;

public interface ProductService {
    Product createProducts(ProductRequest products);
}
