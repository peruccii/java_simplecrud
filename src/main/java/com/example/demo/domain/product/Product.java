package com.example.demo.domain.product;


import jakarta.persistence.*;
import lombok.*;

@Table(name="product")
@Entity(name="product")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.UUID) // Generate UUID id
    private String id;

    private String name;

    private Float price;

    public Product(RequestProductDTO requestProductDTO) {
        this.name = requestProductDTO.name();
        this.price = requestProductDTO.price();
    }
}
