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
        System.out.println("Quieres editar el producto con id:" + producto.getId());
        System.out.println("y le quieres poner un precio de:" + producto.getPrecio());

        /*int pos = repositorio.indexOf(producto);

        if (pos == -1) return null;
        repositorio.set(pos, producto);
        return producto;*/

        for (Producto p : repositorio){
            if (p.getId() == producto.getId()){
                int indice = repositorio.indexOf(p);
                p = producto;
                repositorio.set(indice, p);
                return p;
            }
        }
        return null;
    }

    public void borrar (long id){
        Producto producto = this.obtenerPorId(id);
        if (producto.getNombre() != null){
            repositorio.remove(producto);
        }
    }

    @Override
    public List<Producto> findByCategory(Long idCat) {
        List<Producto> productoCategoria = new ArrayList<>();
        for (Producto producto : repositorio){
            if (producto.getIdCategoria() == idCat){
                productoCategoria.add(producto);
            }
        }
        return productoCategoria;
    }
}
