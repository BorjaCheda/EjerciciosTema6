package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Departamento;
import com.chedacandalesborja.bcc0601.Repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartamentoServiceImplBD implements DepartamentoService{
    @Autowired
    DepartamentoRepository departamentoRepository;
    @Override
    public Departamento añadir(Departamento departamento) {

        return departamentoRepository.save(departamento);
    }

    @Override
    public List<Departamento> obtenerTodos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento obtenerPorId(long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    @Override
    public Departamento editar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public void borrar(Departamento departamento) {
        departamentoRepository.delete(departamento);
    }

    @Override
    public Departamento obtenerPorNombre(String nombre) {
        return departamentoRepository.findByNombre(nombre);
    }
}
