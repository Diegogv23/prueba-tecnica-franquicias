package com.prueba.tecnica.franquicias.application.usecase;

import com.prueba.tecnica.franquicias.domain.model.Product;
import com.prueba.tecnica.franquicias.domain.port.ProductRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductUseCaseTest {

    @Mock
    private ProductRepositoryPort productPort;

    @InjectMocks
    private ProductUseCase productUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSaveAndReturnProductSuccessfully() {
        Product product = new Product("1", "Producto Test", 10, "sucursal-1");
        when(productPort.guardar(any(Product.class))).thenReturn(Mono.just(product));

        Mono<Product> result = productUseCase.agregarProducto(product);

        StepVerifier.create(result)
                .expectNextMatches(p -> p.getName().equals("Producto Test") && p.getStock() == 10)
                .verifyComplete();
    }
}