package com.example.app.services;

import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import com.example.app.repositories.CuentaRepository;
import com.example.app.repositories.MovimientoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    public void modificarSaldo(Movimiento movimiento) {

        if ((movimiento.getImporte() < 1000) || (movimiento.getImporte() > -300)){
                    for (Cuenta c: repositorioCuentas.findAll()) {
                        if (c.getIBAN().equalsIgnoreCase(movimiento.getIBAN())) {
                            Double nuevoSaldo = movimiento.getImporte() + c.getSaldo();
                            if (nuevoSaldo >= 0) {
                                c.setSaldo(nuevoSaldo);
                                if (movimiento.getFecha() == null) movimiento.setFecha(LocalDateTime.now());
                                List<Movimiento> nuevoMov = new ArrayList<>();
                                if (c.getMovimientos() == null) {
                                    nuevoMov.add(movimiento);
                                } else {
                                    nuevoMov = c.getMovimientos();
                                    nuevoMov.add(movimiento);
                                }
                                c.setMovimientos(nuevoMov);
                                System.out.println(c);
                            }
                        }
                    }
                }

            }

    @Override
    public List<Cuenta> findByMovimiento(long idMov) {
        return null;
    }

}
