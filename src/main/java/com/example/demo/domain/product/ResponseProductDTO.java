package com.example.demo.domain.product;

public record ResponseProductDTO(String id, String name, Float price) {
    public ResponseProductDTO(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
