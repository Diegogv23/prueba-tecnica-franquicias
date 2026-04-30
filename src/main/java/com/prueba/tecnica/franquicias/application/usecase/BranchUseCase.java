package com.prueba.tecnica.franquicias.application.usecase;

import com.prueba.tecnica.franquicias.domain.model.Branch;
import com.prueba.tecnica.franquicias.domain.port.BranchRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BranchUseCase {

    private final BranchRepositoryPort branchPort;

    public Mono<Branch> agregarSucursal(Branch sucursal) {
        return branchPort.guardar(sucursal);
    }

    public Mono<Branch> actualizarNombre(String id, String nuevoNombre) {
        return branchPort.actualizarNombre(id, nuevoNombre);
    }
}