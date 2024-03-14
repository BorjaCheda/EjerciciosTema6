package com.example.app.services;

import com.example.app.entity.Usuario;
import com.example.app.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplBD implements UsuarioService{
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImplBD(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario añadir(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario editar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void borrar(long id) {
        usuarioRepository.deleteById(id);
    }
}
