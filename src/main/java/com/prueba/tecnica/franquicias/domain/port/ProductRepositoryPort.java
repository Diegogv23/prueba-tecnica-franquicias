package com.prueba.tecnica.franquicias.domain.port;

import com.prueba.tecnica.franquicias.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepositoryPort {
    Mono<Product> guardar(Product producto);
    Mono<Void> eliminar(String id);
    Mono<Product> actualizarStock(String id, Integer nuevoStock);
    Mono<Product> actualizarNombre(String id, String nuevoNombre);
    Mono<Product> buscarProductoConMasStock(String sucursalId);
}