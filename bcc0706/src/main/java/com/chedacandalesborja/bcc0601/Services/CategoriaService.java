package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Categoria;
import com.chedacandalesborja.bcc0601.Models.Departamento;

import java.util.List;

public interface CategoriaService {
    Categoria añadir(Categoria categoria);
    List<Categoria> obtenerTodos();
    Categoria obtenerPorId(long id);
    Categoria editar(Categoria categoria);
    void borrar(Categoria categoria);
    Categoria obtenerPorNombre(String nombre);
}
