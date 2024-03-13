package com.example.app.services;

import com.example.app.entity.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProductoService {

    public Producto añadir (Producto producto);

    public List<Producto> obtenerTodos();

    public Producto obtenerPorId (long id);

    public Producto editar (Producto producto);

    public void borrar (long id);

    public List<Producto> findByCategory(Long idCat);

}
