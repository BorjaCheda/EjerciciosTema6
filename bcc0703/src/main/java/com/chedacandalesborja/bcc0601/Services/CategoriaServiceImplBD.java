package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Categoria;
import com.chedacandalesborja.bcc0601.Repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaServiceImplBD implements CategoriaService{
    @Autowired
    CategoriaRepository categoriaRepository;
    @Override
    public Categoria añadir(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> obtenerTodos() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria obtenerPorId(long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria editar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void borrar(Categoria categoria) { categoriaRepository.delete(categoria);}

    @Override
    public Categoria obtenerPorNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }
}
