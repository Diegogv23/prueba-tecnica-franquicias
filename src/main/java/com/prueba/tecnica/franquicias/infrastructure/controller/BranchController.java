package com.prueba.tecnica.franquicias.infrastructure.controller;

import com.prueba.tecnica.franquicias.application.dto.BranchRequestDTO;
import com.prueba.tecnica.franquicias.application.usecase.BranchUseCase;
import com.prueba.tecnica.franquicias.domain.model.Branch;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BranchController {

    private final BranchUseCase branchUseCase;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Branch> createBranch(@Valid @RequestBody BranchRequestDTO request) {
        Branch branch = new Branch(UUID.randomUUID().toString(), request.getName(), request.getFranchiseId());
        return branchUseCase.agregarSucursal(branch);
    }
    @PatchMapping("/{id}/name")
    public Mono<Branch> updateBranchName(@PathVariable String id, @RequestParam String newName) {
        return branchUseCase.actualizarNombre(id, newName);
    }
}