package com.example.app.services;

import com.example.app.entity.Categoria;
import com.example.app.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImplBD implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria añadir(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria obtenerPorId(long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria editar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void borrar(long id) {
        categoriaRepository.deleteById(id);
    }
}
