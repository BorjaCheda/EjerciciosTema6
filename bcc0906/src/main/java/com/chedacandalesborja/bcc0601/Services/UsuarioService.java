package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Models.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario añadir(Usuario usuario);

    List<Usuario> obtenerTodos();

    Usuario obtenerPorId(Long id);

    Usuario editar(Usuario usuario);

    void borrar(Long id);

    Usuario findByNombre (String nombre);

}
