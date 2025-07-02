package com.project.sajee.product.service;

import com.project.sajee.product.dto.ProductRequest;
import com.project.sajee.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest products);
    List<ProductResponse> getAllProducts();
}
