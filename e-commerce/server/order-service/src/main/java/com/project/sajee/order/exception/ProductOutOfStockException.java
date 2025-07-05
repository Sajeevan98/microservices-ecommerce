package com.project.sajee.order.exception;

public class ProductOutOfStockException extends RuntimeException{
    public ProductOutOfStockException(String message){
        super(message);
    }
}
