package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Departamento;
import com.chedacandalesborja.bcc0601.Models.Proyecto;
import com.chedacandalesborja.bcc0601.Repositories.DepartamentoRepository;
import com.chedacandalesborja.bcc0601.Repositories.EmpleadoRepository;
import com.chedacandalesborja.bcc0601.Repositories.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProyectoServiceImplBd implements ProyectoService{

    private final ProyectoRepository repositoryProyecto;

    public ProyectoServiceImplBd(ProyectoRepository repositoryProyecto) {
        this.repositoryProyecto = repositoryProyecto;
    }

    @Override
    public Proyecto añadir(Proyecto proyecto) {
        return repositoryProyecto.save(proyecto);
    }

    @Override
    public List<Proyecto> obtenerTodos() {
        return repositoryProyecto.findAll();
    }

    @Override
    public Proyecto obtenerPorId(long id) {
        return repositoryProyecto.findById(id).orElse(null);
    }

    @Override
    public Proyecto editar(Proyecto proyecto) {
        return repositoryProyecto.save(proyecto);
    }

    @Override
    public void borrar(Proyecto proyecto) {
        repositoryProyecto.delete(proyecto);
    }

    @Override
    public Proyecto obtenerPorNombre(String nombre) {
        return repositoryProyecto.findByNombre(nombre);
    }
}
