package com.example.app.services;

import com.example.app.entity.Valoracion;
import com.example.app.repositories.ValoracionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ValoracionServiceImplBD implements ValoracionService{
    private ValoracionRepository valoracionRepository;

    public ValoracionServiceImplBD(ValoracionRepository valoracionRepository) {
        this.valoracionRepository = valoracionRepository;
    }

    @Override
    public Valoracion añadir(Valoracion valoracion) {
        return valoracionRepository.save(valoracion);
    }

    @Override
    public List<Valoracion> obtenerTodas() {
        return valoracionRepository.findAll();
    }

    @Override
    public Valoracion obtenerPorId(long id) {
        return valoracionRepository.findById(id).orElse(null);
    }

    @Override
    public void borrar(long id) {
        valoracionRepository.deleteById(id);
    }
}
