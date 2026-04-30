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
    private ProductRepositoryPort productPort; // Simulamos el puerto

    @InjectMocks
    private ProductUseCase productUseCase; // Inyectamos el simulador en el caso de uso

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void agregarProducto_DeberiaRetornarProductoGuardado() {
        // GIVEN (Dado que...)
        Product producto = new Product("1", "Producto Test", 10, "sucursal-1");
        when(productPort.guardar(any(Product.class))).thenReturn(Mono.just(producto));

        // WHEN (Cuando...)
        Mono<Product> resultado = productUseCase.agregarProducto(producto);

        // THEN (Entonces...)
        StepVerifier.create(resultado)
                .expectNextMatches(p -> p.getName().equals("Producto Test") && p.getStock() == 10)
                .verifyComplete();
    }
}