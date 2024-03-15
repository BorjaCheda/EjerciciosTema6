package com.example.app.services;

import com.example.app.entity.Usuario;
import com.example.app.entity.UsuarioValoracion;

import java.util.List;

public interface UsuarioValoracionService {
    UsuarioValoracion obtenerPorId(Long id);

    UsuarioValoracion añadir(UsuarioValoracion usuarioValoracion);

    void borrar(UsuarioValoracion usuarioValoracion);

    List<UsuarioValoracion> obtenerPorUsuario (Usuario usuario);

}
