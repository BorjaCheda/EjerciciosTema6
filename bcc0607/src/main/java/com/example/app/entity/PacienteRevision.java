package com.example.app.entity;

import com.example.app.config.Tarifas;
import com.example.app.entity.Paciente;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PacienteRevision extends Paciente {

    private String fechaUltimaRevision;
    @Override
    public Integer facturar(Tarifas tarifas){
        long edad= ChronoUnit.YEARS.between(this.getFechaNacimiento(), LocalDate.now());
        if (edad < 65) return tarifas.getTarifaRevisionAdulto();
        else return tarifas.getTarifaRevisonJubilado();
    }


}