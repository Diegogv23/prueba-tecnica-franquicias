package com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb;

import com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb.model.ProductEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;


public interface MongoProductRepository extends ReactiveMongoRepository<ProductEntity, String> {
    Mono<ProductEntity> findTopByBranchIdOrderByStockDesc(String branchId);
}