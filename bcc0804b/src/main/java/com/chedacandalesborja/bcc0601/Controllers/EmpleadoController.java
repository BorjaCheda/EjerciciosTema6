package com.chedacandalesborja.bcc0601.Controllers;

import com.chedacandalesborja.bcc0601.DTO.EmpleadoNuevoDto;
import com.chedacandalesborja.bcc0601.Exceptions.EmpleadoNotFoundException;
import com.chedacandalesborja.bcc0601.Exceptions.EmptyEmpleadosException;
import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.DTO.EmpleadoDto;
import com.chedacandalesborja.bcc0601.Services.DepartamentoService;
import com.chedacandalesborja.bcc0601.Services.EmpleadoServiceImplBD;
import com.chedacandalesborja.bcc0601.Services.EmpleadoDtoConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    public EmpleadoServiceImplBD empleadoService;
    @Autowired
    public ModelMapper modelMapper;
    @Autowired
    public DepartamentoService departamentoService;
    @Autowired
    public EmpleadoDtoConverter empleadoDtoConverter;

    @GetMapping("/empleado")
    public List<Empleado> getList() {
        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        return listaEmpleados;
    }
    @GetMapping("/empleado/{id}")
    public Empleado getOneElement(@PathVariable Long id) {

            return empleadoService.obtenerPorId(id);

    }
    @PostMapping("/empleado")
    public ResponseEntity<?> newElement(@RequestBody EmpleadoNuevoDto empleadoNuevoDto) {
        Empleado empleado = empleadoDtoConverter.convertDtoToEmpleado(empleadoNuevoDto);
        Empleado empleadoSaved = empleadoService.añadir(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoSaved);
    }
    @PutMapping("/empleado/{id}")
    public Empleado editElement(@RequestBody EmpleadoNuevoDto editEmpleado,
                                         @PathVariable Long id) {

            empleadoService.obtenerPorId(id);

            Empleado empleadoSaved = empleadoDtoConverter.convertDtoToEmpleado(editEmpleado, id);

            return empleadoService.editar(empleadoSaved);

    }
    @DeleteMapping("/empleado/{id}")
    public List<Empleado> deleteElement(@PathVariable Long id) {

        try {
            empleadoService.borrar(id);
        } catch (EmpleadoNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        List<Empleado> lista = empleadoService.obtenerTodos();
        return lista;
    }
}
