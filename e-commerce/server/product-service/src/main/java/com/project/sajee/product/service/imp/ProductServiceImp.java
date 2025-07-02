package com.project.sajee.product.service.imp;

import com.project.sajee.product.dto.ProductRequest;
import com.project.sajee.product.model.Product;
import com.project.sajee.product.repository.ProductRepository;
import com.project.sajee.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProducts(ProductRequest products) {
        Product productObj = Product.builder()
                .id(products.id())
                .name(products.name())
                .description(products.description())
                .price(products.price())
                .build();
        if (productObj != null) {
            productRepository.save(productObj);
            log.info("product created successfully!");
            return productObj;
        } else {
            log.info("attempted failed! try again...");
            return null;
        }
    }

}
