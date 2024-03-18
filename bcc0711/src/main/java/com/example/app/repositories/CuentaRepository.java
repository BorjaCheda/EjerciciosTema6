package com.example.app.repositories;

import com.example.app.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    Cuenta findMovimientoById (Long idMov);
    Cuenta findCuentaByIBAN (String IBAN);

}
