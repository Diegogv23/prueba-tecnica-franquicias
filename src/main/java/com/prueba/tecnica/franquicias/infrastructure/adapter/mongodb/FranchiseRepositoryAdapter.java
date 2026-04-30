package com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb;

import com.prueba.tecnica.franquicias.domain.model.Franchise;
import com.prueba.tecnica.franquicias.domain.port.FranchiseRepositoryPort;
import com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb.model.FranchiseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FranchiseRepositoryAdapter implements FranchiseRepositoryPort {

    private final MongoFranchiseRepository repository;
    @Override
    public Mono<Franchise> guardar(Franchise franquicia) {
        FranchiseEntity entity = new FranchiseEntity(franquicia.getId(), franquicia.getName());
        return repository.save(entity)
                .map(saved -> new Franchise(saved.getId(), saved.getName()));
    }
    @Override
    public Mono<Franchise> actualizarNombre(String id, String nuevoNombre) {
        return repository.findById(id)
                .flatMap(entity -> {
                    entity.setName(nuevoNombre);
                    return repository.save(entity);
                })
                .map(saved -> new Franchise(saved.getId(), saved.getName()));
    }

    @Override
    public Mono<Franchise> buscarPorId(String id) {
        return repository.findById(id)
                .map(entity -> new Franchise(entity.getId(), entity.getName()));
    }
}