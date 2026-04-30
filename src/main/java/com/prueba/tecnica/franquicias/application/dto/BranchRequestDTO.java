package com.prueba.tecnica.franquicias.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BranchRequestDTO {

    @NotBlank(message = "El nombre de la sucursal no puede estar vacío")
    private String name;

    @NotBlank(message = "El ID de la franquicia es obligatorio")
    private String franchiseId;
}