package com.example.app.services;

import com.example.app.entity.Producto;
import com.example.app.entity.ProductoValoracion;

import java.util.List;

public interface ProductoValoracionService {
    ProductoValoracion obtenerPorId(Long id);

    ProductoValoracion añadir(ProductoValoracion productoValoracion);

    void borrar(ProductoValoracion productoValoracion);

    List<ProductoValoracion> obtenerPorProducto(Producto producto);

}
