package com.example.app.repositories;

import com.example.app.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    Cuenta findCuentaByIBAN (String IBAN);

}
