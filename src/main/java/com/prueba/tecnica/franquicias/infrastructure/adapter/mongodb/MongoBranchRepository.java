package com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb;

import com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb.model.BranchEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MongoBranchRepository extends ReactiveMongoRepository<BranchEntity, String> {
    Flux<BranchEntity> findByFranchiseId(String franchiseId);
}