package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmpleadoService{

    private List<Empleado> repositorio = new ArrayList<>();   // Repositorio de todos los Empleados que iremos insertando o buscando información

    public Empleado añadir (Empleado empleado){
        repositorio.add(empleado);
        return empleado;
    }

    public Empleado obtenerTodos (){
        return (Empleado) repositorio;
    }

    public Empleado obtenerPorId (long id){
        for (Empleado empleado : repositorio){
            if (empleado.getId() == id){
                return empleado;
            }
        }
        return null; // Si no encuentra el empleado, lanza excepción
    }

    public Empleado editar (Empleado empleado){
        int pos = repositorio.indexOf(empleado);
        if (pos == -1){
            return null; // Si no encuentra el empleado, lanza excepción
        } else {
            repositorio.set(pos, empleado); // Si encuentra el empleado, lo sustituye por el que le dices.
        }
        return empleado;
    }

    public void borrar (long id){
        Empleado empleado = this.obtenerPorId(id);
        if (empleado != null){
            repositorio.remove(empleado);
        }
    }
}
