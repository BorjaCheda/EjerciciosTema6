package com.example.app.services;

import com.example.app.entity.Categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImplMem implements CategoriaService{

    private List<Categoria> repositorioCategorias = new ArrayList<>();

    public Categoria añadir(Categoria categoria) {
        repositorioCategorias.add(categoria);
        return categoria;
    }

    public List<Categoria> obtenerTodas() {
        return repositorioCategorias;
    }

    public Categoria obtenerPorId(long id) {
        for (Categoria categoria: repositorioCategorias){
            if (categoria.getId() == id) return categoria;
        }
        return null;
    }

    public Categoria editar(Categoria categoria) {
        int pos_categoria = repositorioCategorias.indexOf(categoria);

        if (pos_categoria != -1)
            repositorioCategorias.set(pos_categoria, categoria);

        return categoria;
    }

    @Override
    public void borrar(long id) {
        Categoria categoria = this.obtenerPorId(id);
        if (categoria.getId() == id){
            repositorioCategorias.remove(categoria);
        }
    }
}
