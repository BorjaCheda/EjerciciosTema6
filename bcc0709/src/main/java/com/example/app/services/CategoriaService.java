package com.example.app.services;

import com.example.app.entity.Categoria;
import com.example.app.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriaService {

    public Categoria añadir (Categoria categoria);

    public List<Categoria> obtenerTodas();

    public Categoria obtenerPorId (long id);

    public Categoria editar (Categoria categoria);

    public void borrar (long id);

}
