package com.example.app.services;

import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import com.example.app.repositories.CuentaRepository;
import com.example.app.repositories.MovimientoRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CuentaServiceImplBD implements CuentaService {

    private final MovimientoRepository movimientoRepository;
    private CuentaRepository repositorioCuentas;

    public CuentaServiceImplBD(CuentaRepository repositorioCuentas,
                               MovimientoRepository movimientoRepository) {
        this.repositorioCuentas = repositorioCuentas;
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public Cuenta agregar(Cuenta cuenta) {
        double saldoInicial = 0;
        if (cuenta.getSaldo() == null) cuenta.setSaldo(saldoInicial);
        return repositorioCuentas.save(cuenta);
    }

    @Override
    public List<Cuenta> obtenerTodos() {
        return repositorioCuentas.findAll();
    }

    @Override
    public Cuenta obtenerPorIBAN(String IBAN) {
        return repositorioCuentas.findCuentaByIBAN(IBAN);
    }

    @Override
    public Cuenta editar(Cuenta cuenta) {

        for (Cuenta c : repositorioCuentas.findAll()) {
            if (c.getIBAN().equalsIgnoreCase(cuenta.getIBAN())) {
                cuenta.setId(c.getId());
            }
        }

        return repositorioCuentas.save(cuenta);
    }

    @Override
    public void borrar(Long id) {
        repositorioCuentas.deleteById(id);
    }

    @Override
    public void modificarSaldo(Movimiento movimiento) {

        if ((movimiento.getImporte() < 1000) || (movimiento.getImporte() > -300)) {
            Cuenta c = repositorioCuentas.findCuentaByIBAN(movimiento.getIBAN());
            if (c.getId() != null && c.getId() != 0) {
                Double nuevoSaldo = movimiento.getImporte() + c.getSaldo();
                if (nuevoSaldo >= 0) {
                    c.setSaldo(nuevoSaldo);
                    movimientoRepository.save(movimiento);
                    if (movimiento.getFecha() == null) {
                        movimiento.setFecha(LocalDateTime.now());
                    }
                    c.getMovimientos().add(movimiento);
                    repositorioCuentas.save(c);
                }
            }
        }
    }

    @Override
    public List<Cuenta> findByMovimiento(long idMov) {
        return null;
    }

}
