package com.example.app.services;

import com.example.app.entity.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImplMem implements ProductoService{

    private List<Producto> repositorio = new ArrayList<>();

    public Producto añadir (Producto producto){
        repositorio.add(producto);
        return producto;
    }

    public List<Producto> obtenerTodos(){
        return repositorio;
    }

    public Producto obtenerPorId (long id){
        for (Producto producto : repositorio){
            if (producto.getId() == id)
                return producto;
        }
        return null;
    }

    public Producto editar (Producto producto){
        int posicion = repositorio.indexOf(producto);

        if (posicion == -1) return null;
        repositorio.set(posicion, producto);
        return producto;
    }

    public void borrar (long id){
        Producto producto = this.obtenerPorId(id);
        if (producto.getNombre() != null){
            repositorio.remove(producto);
        }
    }
}
