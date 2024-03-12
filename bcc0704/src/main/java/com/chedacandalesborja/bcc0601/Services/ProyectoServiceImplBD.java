package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Proyecto;
import com.chedacandalesborja.bcc0601.Repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProyectoServiceImplBD implements ProyectoService{
    @Autowired
    ProyectoRepository proyectoRepository;
    @Override
    public Proyecto añadir(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public List<Proyecto> obtenerTodos() {
        return proyectoRepository.findAll();
    }

    @Override
    public Proyecto obtenerPorId(long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    public Proyecto editar(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public void borrar(Proyecto proyecto) {
        proyectoRepository.delete(proyecto);
    }

    @Override
    public Proyecto obtenerPorNombre(String nombre) {
        return proyectoRepository.findByNombre(nombre);
    }
}
