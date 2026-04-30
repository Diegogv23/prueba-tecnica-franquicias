package com.prueba.tecnica.franquicias.domain.port;

import com.prueba.tecnica.franquicias.domain.model.Branch;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BranchRepositoryPort {
    Mono<Branch> guardar(Branch sucursal);
    Mono<Branch> actualizarNombre(String id, String nuevoNombre);
    Flux<Branch> buscarPorFranquiciaId(String franquiciaId);
}