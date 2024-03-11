package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Departamento;
import com.chedacandalesborja.bcc0601.Models.Proyecto;

import java.util.List;

public interface ProyectoService {
    Proyecto añadir(Proyecto proyecto);
    List<Proyecto> obtenerTodos();
    Proyecto obtenerPorId(long id);
    Proyecto editar(Proyecto proyecto);
    void borrar(Proyecto proyecto);
    Proyecto obtenerPorNombre(String nombre);
}
