package com.example.app.services;

import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService{
    private List<Movimiento> repositorioMovimientos = new ArrayList<>();
    @Override
    public Movimiento agregar(Movimiento movimiento) {
        repositorioMovimientos.add(movimiento);
        return movimiento;
    }
    @Override
    public List<Movimiento> obtenerTodos() {
        return repositorioMovimientos;
    }

    @Override
    public Movimiento obtenerPorId(long id) {
        for (Movimiento m : repositorioMovimientos){
            if (m.getId() == id){
                int indiceMovimiento = repositorioMovimientos.indexOf(m);
                repositorioMovimientos.set(indiceMovimiento, m);
                return m;
            }
        }
        return null;
    }


}
