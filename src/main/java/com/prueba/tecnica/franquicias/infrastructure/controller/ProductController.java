package com.prueba.tecnica.franquicias.infrastructure.controller;

import com.prueba.tecnica.franquicias.application.dto.ProductRequestDTO;
import com.prueba.tecnica.franquicias.application.usecase.ProductUseCase;
import com.prueba.tecnica.franquicias.domain.model.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor

public class ProductController {

    private final ProductUseCase productUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> createProduct(@Valid @RequestBody ProductRequestDTO request) {
        Product product = new Product(UUID.randomUUID().toString(), request.getName(), request.getStock(), request.getBranchId());
        return productUseCase.agregarProducto(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return productUseCase.eliminarProducto(id);
    }

    @PatchMapping("/{id}/stock")
    public Mono<Product> updateProductStock(@PathVariable String id, @RequestParam Integer newStock) {
        return productUseCase.actualizarStock(id, newStock);
    }

    @PatchMapping("/{id}/name")
    public Mono<Product> updateProductName(@PathVariable String id, @RequestParam String newName) {
        return productUseCase.actualizarNombre(id, newName);
    }
}