package com.example.app.services;

import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import com.example.app.repositories.CuentaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImplBD implements CuentaService {

    private CuentaRepository repositorioCuentas;

    public CuentaServiceImplBD(CuentaRepository repositorioCuentas) {
        this.repositorioCuentas = repositorioCuentas;
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
    public Cuenta obtenerPorIBAN(String IBAN) { return repositorioCuentas.findCuentaByIBAN(IBAN);
    }

    @Override
    public Cuenta editar(Cuenta cuenta) {

        for (Cuenta c: repositorioCuentas.findAll()){
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
    public void modificarSaldo(Movimiento movimiento, String IBAN) {
        Cuenta cuenta= repositorioCuentas.findCuentaByIBAN(IBAN);
        if ((movimiento.getImporte() < 1000) || (movimiento.getImporte() > -300)){

                    Double nuevoSaldo = movimiento.getImporte() + cuenta.getSaldo();
                    if (nuevoSaldo >= 0){
                        cuenta.setSaldo(nuevoSaldo);
                        repositorioCuentas.save(cuenta);
                        if (movimiento.getFecha() == null) movimiento.setFecha(LocalDateTime.now());
                        List<Movimiento> nuevoMov = new ArrayList<>();
                        if (cuenta.getMovimiento() == null){
                            nuevoMov.add(movimiento);
                        } else {
                            nuevoMov = cuenta.getMovimiento();
                            nuevoMov.add(movimiento);
                        }
                        cuenta.setMovimiento(nuevoMov);
                        System.out.println(cuenta);
                    }
                }
            }
    @Override
    public Cuenta findMovimientoById(long idMov) {
        return repositorioCuentas.findMovimientoById(idMov);
    }
}
