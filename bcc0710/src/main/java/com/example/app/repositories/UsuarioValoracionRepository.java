package com.example.app.repositories;

import com.example.app.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioValoracionRepository extends JpaRepository<UsuarioValoracion, Long> {
    List<UsuarioValoracion> findByUsuario (Usuario usuario);

    List<UsuarioValoracion> findByProducto (Producto producto);
}
