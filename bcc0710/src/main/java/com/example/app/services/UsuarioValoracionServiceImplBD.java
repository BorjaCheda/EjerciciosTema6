package com.example.app.services;

import com.example.app.entity.Usuario;
import com.example.app.entity.UsuarioValoracion;
import com.example.app.repositories.UsuarioValoracionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioValoracionServiceImplBD implements UsuarioValoracionService{

    private UsuarioValoracionRepository usuarioValoracionRepository;

    public UsuarioValoracionServiceImplBD(UsuarioValoracionRepository usuarioValoracionRepository) {
        this.usuarioValoracionRepository = usuarioValoracionRepository;
    }

    @Override
    public UsuarioValoracion obtenerPorId(Long id) {
        return usuarioValoracionRepository.findById(id).orElse(null);
    }

    @Override
    public UsuarioValoracion añadir(UsuarioValoracion usuarioValoracion) {
        return usuarioValoracionRepository.save(usuarioValoracion);
    }

    @Override
    public void borrar(UsuarioValoracion usuarioValoracion) {
            usuarioValoracionRepository.delete(usuarioValoracion);
    }

    @Override
    public List<UsuarioValoracion> obtenerPorUsuario(Usuario usuario) {
        return usuarioValoracionRepository.findByUsuario(usuario);
    }
}
