package com.example.app.services;

import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    private List<Cuenta> repositorio = new ArrayList<>();

    @Override
    public Cuenta agregar(Cuenta cuenta) {
        repositorio.add(cuenta);
        return cuenta;
    }

    @Override
    public List<Cuenta> obtenerTodos() {
        return null;
    }

    @Override
    public Cuenta obtenerPorIBAN(String IBAN) {
        return null;
    }

    @Override
    public Cuenta editar(Cuenta cuenta) {
        return null;
    }

    @Override
    public void borrar(String IBAN) {

    }

    @Override
    public void modificarSaldo(Movimiento movimiento) {

    }

    @Override
    public List<Cuenta> findByMovimiento(long idMov) {
        return null;
    }
}
