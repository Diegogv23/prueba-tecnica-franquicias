package com.prueba.tecnica.franquicias.infrastructure.controller;

import com.prueba.tecnica.franquicias.application.dto.FranchiseRequestDTO;
import com.prueba.tecnica.franquicias.application.usecase.BranchUseCase;
import com.prueba.tecnica.franquicias.application.usecase.FranchiseUseCase;
import com.prueba.tecnica.franquicias.application.usecase.ProductUseCase;
import com.prueba.tecnica.franquicias.domain.model.Franchise;
import com.prueba.tecnica.franquicias.domain.model.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/franchises")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FranchiseController {

    private final FranchiseUseCase franchiseUseCase;
    private final BranchUseCase branchUseCase;
    private final ProductUseCase productUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Franchise> createFranchise(@Valid @RequestBody FranchiseRequestDTO request) {
        Franchise franchise = new Franchise(UUID.randomUUID().toString(), request.getName());
        return franchiseUseCase.agregarFranquicia(franchise);
    }

    @PatchMapping("/{id}/name")
    public Mono<Franchise> updateFranchiseName(@PathVariable String id, @RequestParam String newName) {
        return franchiseUseCase.actualizarNombre(id, newName);
    }

    @GetMapping("/{id}/max-stock-products")
    public Flux<Product> getMaxStockProductsByFranchise(@PathVariable String id) {
        return branchUseCase.buscarPorFranquiciaId(id)
                .flatMap(branch -> productUseCase.productoConMasStockPorSucursal(branch.getId()));
    }
}