package com.example.app.services;

import com.example.app.entity.Paciente;
import com.example.app.entity.PacienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PacienteService {

    void add (Paciente paciente);

    void deleteFirst();

    Paciente getFirst();

    List<Paciente> findAll();

    Paciente buildPacienteFromDTO (PacienteDTO pacienteDTO);

    Integer facturar (Paciente paciente);

}
