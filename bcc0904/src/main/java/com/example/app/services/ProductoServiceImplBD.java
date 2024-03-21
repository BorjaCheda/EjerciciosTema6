package com.example.app.services;

import com.example.app.entity.Categoria;
import com.example.app.entity.Producto;
import com.example.app.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImplBD implements ProductoService{

    @Autowired
    ProductoRepository productoRepository;
    public Producto añadir (Producto producto){
        return productoRepository.save(producto);
    }
    public List<Producto> obtenerTodos(){
        return productoRepository.findAll();
    }
    public Producto obtenerPorId (long id){
        return productoRepository.findById(id).orElse(null);
    }
    public Producto editar (Producto producto){
       return productoRepository.save(producto);
    }
    public void borrar (long id){
        productoRepository.deleteById(id);
    }
    @Override
    public List<Producto> findProductoByCategoria(Categoria categoria) {
        return productoRepository.findProductoByCategoria(categoria);
    }
}
