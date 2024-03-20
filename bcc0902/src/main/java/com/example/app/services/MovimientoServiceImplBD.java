package com.example.app.services;

import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import com.example.app.repositories.CuentaRepository;
import com.example.app.repositories.MovimientoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoServiceImplBD implements MovimientoService {
    private MovimientoRepository repositorioMovimientos;

    public MovimientoServiceImplBD(MovimientoRepository repositorioMovimientos) {
        this.repositorioMovimientos = repositorioMovimientos;

    }

    @Override
    public List<Movimiento> obtenerTodos() {
        return repositorioMovimientos.findAll();
    }

    @Override
    public Movimiento obtenerPorId(Long id) {
        return repositorioMovimientos.findById(id).orElse(null);
    }
    
    @Override
    public List<Movimiento> findMovimientoByIBAN(String IBAN) {
        return repositorioMovimientos.findMovimientoByIBAN(IBAN);
    }

}
