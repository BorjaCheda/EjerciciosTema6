package com.chedacandalesborja.bcc0601.Repositories;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
