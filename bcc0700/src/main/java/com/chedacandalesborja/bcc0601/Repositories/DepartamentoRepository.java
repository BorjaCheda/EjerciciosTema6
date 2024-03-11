package com.chedacandalesborja.bcc0601.Repositories;

import com.chedacandalesborja.bcc0601.Models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Departamento findByNombre (String nombre);
}
