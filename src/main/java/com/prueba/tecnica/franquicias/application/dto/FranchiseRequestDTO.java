package com.prueba.tecnica.franquicias.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FranchiseRequestDTO {

    @NotBlank(message = "El nombre de la franquicia no puede estar vacío")
    private String name;
}