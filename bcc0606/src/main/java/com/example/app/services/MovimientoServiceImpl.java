package com.example.app.services;

import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService{
    private List<Movimiento> repositorio = new ArrayList<>();
}
