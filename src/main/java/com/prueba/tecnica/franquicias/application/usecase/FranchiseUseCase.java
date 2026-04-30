package com.prueba.tecnica.franquicias.application.usecase;

import com.prueba.tecnica.franquicias.domain.model.Franchise;
import com.prueba.tecnica.franquicias.domain.port.FranchiseRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FranchiseUseCase {

    private final FranchiseRepositoryPort franchisePort;

    public Mono<Franchise> agregarFranquicia(Franchise franquicia) {
        return franchisePort.guardar(franquicia);
    }

    public Mono<Franchise> actualizarNombre(String id, String nuevoNombre) {
        return franchisePort.actualizarNombre(id, nuevoNombre);
    }
}