package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Departamento;

import java.util.List;

public interface DepartamentoService {
    Departamento añadir(Departamento departamento);
    List<Departamento> obtenerTodos();
    Departamento obtenerPorId(Long id);
    Departamento editar(Departamento departamento);
    void borrar(Long id);
    Departamento obtenerPorNombre(String nombre);
}