package com.example.app.services;

import com.example.app.entity.Categoria;
import com.example.app.entity.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProductoService {

    Producto añadir (Producto producto);

   List<Producto> obtenerTodos();

   Producto obtenerPorId (long id);

    Producto editar (Producto producto);

    void borrar (long id);

    List<Producto> findProductoByCategoria (Categoria categoria);

}
