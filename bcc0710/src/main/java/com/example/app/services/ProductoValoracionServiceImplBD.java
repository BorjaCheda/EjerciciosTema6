package com.example.app.services;

import com.example.app.entity.Producto;
import com.example.app.entity.ProductoValoracion;
import com.example.app.entity.Valoracion;
import com.example.app.repositories.ProductoValoracionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoValoracionServiceImplBD implements ProductoValoracionService{
    private ProductoValoracionRepository productoValoracionRepository;

    public ProductoValoracionServiceImplBD(ProductoValoracionRepository productoValoracionRepository) {
        this.productoValoracionRepository = productoValoracionRepository;
    }

    @Override
    public ProductoValoracion obtenerPorId(Long id) {
        return productoValoracionRepository.findById(id).orElse(null);
    }

    @Override
    public ProductoValoracion añadir(ProductoValoracion productoValoracion) {
        return productoValoracionRepository.save(productoValoracion);
    }

    @Override
    public void borrar(ProductoValoracion productoValoracion) {
        productoValoracionRepository.delete(productoValoracion);
    }

    @Override
    public List<ProductoValoracion> obtenerPorProducto(Producto producto) {
        return productoValoracionRepository.findByProducto(producto);
    }

}
