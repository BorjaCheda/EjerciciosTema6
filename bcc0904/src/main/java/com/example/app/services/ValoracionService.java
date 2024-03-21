package com.example.app.services;

import com.example.app.entity.Categoria;
import com.example.app.entity.Valoracion;

import java.util.List;

public interface ValoracionService {
    public Valoracion añadir (Valoracion valoracion);

    public List<Valoracion> obtenerTodas();

    public Valoracion obtenerPorId (long id);

    public void borrar (long id);
}
