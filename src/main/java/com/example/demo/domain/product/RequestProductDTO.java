package com.example.demo.domain.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

//DTO
public record RequestProductDTO(

        @NotEmpty
        String name,
        @NotNull
        Float price
) {


}
