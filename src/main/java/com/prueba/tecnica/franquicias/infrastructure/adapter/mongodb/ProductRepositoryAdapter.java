package com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb;

import com.prueba.tecnica.franquicias.domain.model.Product;
import com.prueba.tecnica.franquicias.domain.port.ProductRepositoryPort;
import com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb.model.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final MongoProductRepository repository;

    @Override
    public Mono<Product> guardar(Product producto) {
        ProductEntity entity = new ProductEntity(producto.getId(), producto.getName(), producto.getStock(), producto.getBranchId());
        return repository.save(entity)
                .map(saved -> new Product(saved.getId(), saved.getName(), saved.getStock(), saved.getBranchId()));
    }

    @Override
    public Mono<Void> eliminar(String id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<Product> actualizarStock(String id, Integer nuevoStock) {
        return repository.findById(id)
                .flatMap(entity -> {
                    entity.setStock(nuevoStock);
                    return repository.save(entity);
                })
                .map(saved -> new Product(saved.getId(), saved.getName(), saved.getStock(), saved.getBranchId()));
    }

    @Override
    public Mono<Product> actualizarNombre(String id, String nuevoNombre) {
        return repository.findById(id)
                .flatMap(entity -> {
                    entity.setName(nuevoNombre);
                    return repository.save(entity);
                })
                .map(saved -> new Product(saved.getId(), saved.getName(), saved.getStock(), saved.getBranchId()));
    }

    @Override
    public Mono<Product> buscarProductoConMasStock(String sucursalId) {
        return repository.findTopByBranchIdOrderByStockDesc(sucursalId)
                .map(entity -> new Product(entity.getId(), entity.getName(), entity.getStock(), entity.getBranchId()));
    }
}