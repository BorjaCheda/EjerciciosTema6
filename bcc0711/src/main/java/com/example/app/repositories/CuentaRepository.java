package com.example.app.repositories;

import com.example.app.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, String> {
    List<Cuenta> finByMovimiento (Long idMov);
}
