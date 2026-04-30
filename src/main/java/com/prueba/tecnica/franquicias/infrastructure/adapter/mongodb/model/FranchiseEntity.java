package com.prueba.tecnica.franquicias.infrastructure.adapter.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "franchises")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranchiseEntity {
    @Id
    private String id;
    private String name;
}