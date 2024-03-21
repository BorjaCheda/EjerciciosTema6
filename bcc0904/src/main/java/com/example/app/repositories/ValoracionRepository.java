package com.example.app.repositories;

import com.example.app.entity.Producto;
import com.example.app.entity.Usuario;
import com.example.app.entity.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {
    //List<Valoracion> findByProducto (Producto producto);
    //List<Valoracion> findByUsuario (Usuario usuario);

}
