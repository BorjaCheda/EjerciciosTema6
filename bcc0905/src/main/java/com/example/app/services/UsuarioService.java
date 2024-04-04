package com.example.app.services;

import com.example.app.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario añadir (Usuario usuario);

    List<Usuario> obtenerTodos();

    Usuario obtenerPorId (long id);

    Usuario editar (Usuario usuario);

    void borrar (long id);

    Usuario findByNombre(String username);

}
