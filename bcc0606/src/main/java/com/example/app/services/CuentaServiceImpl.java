package com.example.app.services;

import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    private List<Cuenta> repositorioCuentas = new ArrayList<>();

    @Override
    public Cuenta agregar(Cuenta cuenta) {

        repositorioCuentas.add(cuenta);
        return cuenta;
    }

    @Override
    public List<Cuenta> obtenerTodos() {
        return repositorioCuentas;
    }

    @Override
    public Cuenta obtenerPorIBAN(String IBAN) {
        for (Cuenta c : repositorioCuentas){
            if (c.getIBAN().equalsIgnoreCase(IBAN)){
                return c;
            }
        }
        return null;
    }

    @Override
    public Cuenta editar(Cuenta cuenta) {
        for (Cuenta c : repositorioCuentas){
            if (c.getIBAN() == cuenta.getIBAN()){
                int indiceCuenta = repositorioCuentas.indexOf(cuenta);
                repositorioCuentas.set(indiceCuenta, c);
                return c;
            }
        }
        return null;
    }

    @Override
    public void borrar (String IBAN) {

        Cuenta c = this.obtenerPorIBAN(IBAN);
        System.out.println(c.getIBAN());

        if (c != null && c.getSaldo() == 0){
            Iterator<Movimiento> iterator = c.getMovimientos().iterator();
            while (iterator.hasNext()) {
                Movimiento movimiento = iterator.next();
                if (movimiento.getIBAN().equals(IBAN))
                    iterator.remove();
            }
            repositorioCuentas.remove(c);
        }
    }

    @Override
    public void modificarSaldo(Movimiento movimiento) {

        if ((movimiento.getImporte() < 1000) || (movimiento.getImporte() > -300)){
            for (Cuenta c : repositorioCuentas){
                if (c.getIBAN() == movimiento.getIBAN()){
                    Double nuevoSaldo = movimiento.getImporte() + c.getSaldo();
                    c.setSaldo(nuevoSaldo);
                    int indiceCuenta = repositorioCuentas.indexOf(c);
                    repositorioCuentas.set(indiceCuenta,c);
                    if (movimiento.getFecha() == null) movimiento.setFecha(LocalDateTime.now());
                    List<Movimiento> nuevoMov = new ArrayList<>();
                    if (c.getMovimientos() == null){
                        nuevoMov.add(movimiento);
                    } else {
                        nuevoMov = c.getMovimientos();
                        nuevoMov.add(movimiento);
                    }
                    c.setMovimientos(nuevoMov);
                }
            }
        }
    }

    @Override
    public List<Cuenta> findByMovimiento(long idMov) {
        List<Cuenta> cuentas = new ArrayList<>();
        for (Cuenta c : repositorioCuentas){
            return null;
        }
        return null;
    }

}
