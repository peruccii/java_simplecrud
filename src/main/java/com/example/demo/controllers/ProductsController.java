package com.example.demo.controllers;

import com.example.demo.domain.product.IProductRepository;
import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.RequestProductDTO;
import com.example.demo.domain.product.ResponseProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductsController {
    @Autowired
    private IProductRepository repository;

    @GetMapping
    public ResponseEntity getAllProducts() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity insertProduct(@RequestBody @Valid RequestProductDTO data) {
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity updateProduct(@PathVariable String idProduct, @Valid @RequestBody RequestProductDTO data) {
        Product product = repository.getReferenceById(idProduct);
        product.setName(data.name());
        product.setPrice(data.price());
        return ResponseEntity.ok(new ResponseProductDTO((product)));
    }

    @DeleteMapping
    public ResponseEntity deleteProduct(@RequestParam String idProduct) {
        var product = repository.findById(idProduct);
        repository.deleteById(idProduct);
        return ResponseEntity.ok(product);
    }
}
