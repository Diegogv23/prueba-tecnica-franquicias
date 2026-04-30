package com.prueba.tecnica.franquicias.application.usecase;

import com.prueba.tecnica.franquicias.domain.model.Product;
import com.prueba.tecnica.franquicias.domain.port.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductRepositoryPort productPort;

    public Mono<Product> agregarProducto(Product producto) {
        return productPort.guardar(producto);
    }

    public Mono<Void> eliminarProducto(String id) {
        return productPort.eliminar(id);
    }

    public Mono<Product> actualizarStock(String id, Integer nuevoStock) {
        return productPort.actualizarStock(id, nuevoStock);
    }

    public Mono<Product> actualizarNombre(String id, String nuevoNombre) {
        return productPort.actualizarNombre(id, nuevoNombre);
    }

    public Mono<Product> productoConMasStockPorSucursal(String sucursalId) {
        return productPort.buscarProductoConMasStock(sucursalId);
    }
}