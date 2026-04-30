package com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb;

import com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb.model.FranchiseEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MongoFranchiseRepository extends ReactiveMongoRepository<FranchiseEntity, String> {
}