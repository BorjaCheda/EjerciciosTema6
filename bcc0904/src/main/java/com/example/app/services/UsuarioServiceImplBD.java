package com.example.app.services;

import com.example.app.entity.Usuario;
import com.example.app.repositories.UsuarioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class UsuarioServiceImplBD implements UsuarioService{
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    public UsuarioServiceImplBD(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario añadir(Usuario usuario) {
        if (usuarioRepository.findByNombre(usuario.getNombre()) != null)
            return null; //ya existe ese nombre de usuario
        String passCrypted = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passCrypted);
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

        String passCrypted = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passCrypted);
        try {
            return usuarioRepository.save(usuario);
        } catch (DataIntegrityViolationException e)
        {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void borrar(long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findByNombre(String username) { return usuarioRepository.findByNombre(username);
    }
}
