package com.example.app.services;

import com.example.app.config.Tarifas;
import com.example.app.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteServiceImplMem implements PacienteService{
    private ArrayList<Paciente> repositorioPacientes = new ArrayList<>();

    @Autowired
    Tarifas tarifas;
    @Override
    public void add(Paciente paciente) {
        repositorioPacientes.add(paciente);
    }

    @Override
    public void deleteFirst() {
        repositorioPacientes.remove(0);
    }

    @Override
    public Paciente getFirst() {
        if (repositorioPacientes.size() > 0){
            return repositorioPacientes.get(0);
        }
        return null;
    }

    @Override
    public List<Paciente> findAll() {
        return repositorioPacientes;
    }

    @Override
    public Paciente buildPacienteFromDTO(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente() {
            @Override
            public Integer facturar(Tarifas tarifas) {
                return null;
            }
        };
        System.out.println(pacienteDTO.toString());
        System.out.println(pacienteDTO.getTipoPaciente());

        if (pacienteDTO.getTipoPaciente().compareTo(1)){
            paciente = new PacienteConsulta();
            ((PacienteConsulta)paciente).setMotivoConsulta(pacienteDTO.getMotivoConsulta());
            System.out.println(paciente.toString());
        }
        if (pacienteDTO.getTipoPaciente() == 2){
            paciente = new PacienteRecetas();
            ((PacienteRecetas)paciente).setRecetas(pacienteDTO.getRecetas());
            System.out.println(paciente.toString());
        }
        if (pacienteDTO.getTipoPaciente() == 3){
            paciente = new PacienteRevision();
            ((PacienteRevision)paciente).setFechaUltimaRevision(String.valueOf(pacienteDTO.getFechaUltimaRevision()));
            System.out.println(paciente.toString());
        }

        System.out.println(paciente.toString());
        paciente.setDNI(pacienteDTO.getDNI());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        System.out.println(paciente.toString());
        return paciente;

    }

    @Override
    public Integer facturar(Paciente paciente) {
        if(paciente != null)
            return paciente.facturar(tarifas);
        else
            return  0;
    }
}
