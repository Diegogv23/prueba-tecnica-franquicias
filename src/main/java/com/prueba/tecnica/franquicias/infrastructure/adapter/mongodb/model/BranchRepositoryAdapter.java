package com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb;

import com.prueba.tecnica.franquicias.domain.model.Branch;
import com.prueba.tecnica.franquicias.domain.port.BranchRepositoryPort;
import com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb.model.BranchEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
@RequiredArgsConstructor
public class BranchRepositoryAdapter implements BranchRepositoryPort {

    private final MongoBranchRepository repository;

    @Override
    public Mono<Branch> guardar(Branch sucursal) {
        BranchEntity entity = new BranchEntity(sucursal.getId(), sucursal.getName(), sucursal.getFranchiseId());
        return repository.save(entity)
                .map(saved -> new Branch(saved.getId(), saved.getName(), saved.getFranchiseId()));
    }
    @Override
    public Mono<Branch> actualizarNombre(String id, String nuevoNombre) {
        return repository.findById(id)
                .flatMap(entity -> {
                    entity.setName(nuevoNombre);
                    return repository.save(entity);
                })
                .map(saved -> new Branch(saved.getId(), saved.getName(), saved.getFranchiseId()));
    }
    @Override
    public Flux<Branch> buscarPorFranquiciaId(String franquiciaId) {
        return repository.findByFranchiseId(franquiciaId)
                .map(entity -> new Branch(entity.getId(), entity.getName(), entity.getFranchiseId()));
    }
}