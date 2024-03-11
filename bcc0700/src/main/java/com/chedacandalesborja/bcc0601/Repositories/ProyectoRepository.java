package com.chedacandalesborja.bcc0601.Repositories;

import com.chedacandalesborja.bcc0601.Models.Departamento;
import com.chedacandalesborja.bcc0601.Models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    Proyecto findByNombre (String nombre);
}
