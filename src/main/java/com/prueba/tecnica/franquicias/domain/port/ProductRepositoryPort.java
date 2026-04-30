package com.prueba.tecnica.franquicias.domain.port;

import com.prueba.tecnica.franquicias.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepositoryPort {
    Mono<Product> save(Product product); // Guardar o actualizar
    Mono<Void> deleteById(String id);    // Eliminar por ID
    Mono<Product> findById(String id);   // Buscar uno solo
    Mono<Product> findTopByBranchIdOrderByStockDesc(String branchId);
}