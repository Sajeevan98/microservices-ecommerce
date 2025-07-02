package com.project.sajee.product.service.imp;

import com.project.sajee.product.dto.ProductRequest;
import com.project.sajee.product.dto.ProductResponse;
import com.project.sajee.product.model.Product;
import com.project.sajee.product.repository.ProductRepository;
import com.project.sajee.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest products) {
        Product productObj = Product.builder()
                .id(products.id())
                .name(products.name())
                .description(products.description())
                .price(products.price())
                .build();
        if (productObj != null) {
            productRepository.save(productObj);
            log.info("product created successfully!");
            return new ProductResponse(productObj.getId(), productObj.getName(), productObj.getDescription(), productObj.getPrice());
        } else {
            log.info("attempted failed! try again...");
            return null;
        }
    }

    @Override
    public List<ProductResponse> getAllProducts() {

        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty())
            log.info("no products available right now.");

        return productList
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()
                ))
                .toList();
    }

}
