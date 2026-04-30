package com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "branches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchEntity {
    @Id
    private String id;

    private String name;

    private String franchiseId;
}