package com.project.sajee.product.controller;

import com.project.sajee.product.dto.ProductRequest;
import com.project.sajee.product.dto.ProductResponse;
import com.project.sajee.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1.0/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addProduct(@RequestBody ProductRequest products){
        return productService.createProduct(products);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<ProductResponse> findAllProducts(){
        return productService.getAllProducts();
    }
}
