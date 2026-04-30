package com.prueba.tecnica.franquicias.domain.port;

import com.prueba.tecnica.franquicias.domain.model.Franchise;
import reactor.core.publisher.Mono;

public interface FranchiseRepositoryPort {
    Mono<Franchise> guardar(Franchise franquicia);
    Mono<Franchise> actualizarNombre(String id, String nuevoNombre);
    Mono<Franchise> buscarPorId(String id);
}