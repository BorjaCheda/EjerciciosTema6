package com.chedacandalesborja.bcc0601.Controllers;

import com.chedacandalesborja.bcc0601.DTO.EmpleadoNuevoDto;
import com.chedacandalesborja.bcc0601.Models.Departamento;
import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.DTO.EmpleadoDto;
import com.chedacandalesborja.bcc0601.Services.DepartamentoService;
import com.chedacandalesborja.bcc0601.Services.EmpleadoServiceImplBD;
import com.chedacandalesborja.bcc0601.Services.EmpleadoDtoConverter;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> getList() {
        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        if (listaEmpleados.isEmpty())
            return ResponseEntity.notFound().build(); // cod 404
        else{
            List<EmpleadoDto> listaEmpleadoDto = new ArrayList<>();
            for (Empleado e : listaEmpleados)
                listaEmpleadoDto.add(modelMapper.map(e, EmpleadoDto.class));
            return ResponseEntity.ok(listaEmpleadoDto); // cod 200
        }
    }
    @GetMapping("/empleado/{id}")
    public ResponseEntity<?> getOneElement(@PathVariable Long id) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404
        else
            return ResponseEntity.ok(empleado); // cod 200
    }
    @PostMapping("/empleado")
    public ResponseEntity<?> newElement(@RequestBody EmpleadoNuevoDto empleadoNuevoDto) {
        Empleado empleado = empleadoDtoConverter.convertDtoToEmpleado(empleadoNuevoDto);
        Empleado empleadoSaved = empleadoService.añadir(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoSaved);
    }
    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> editElement(@RequestBody EmpleadoNuevoDto editEmpleado,
                                         @PathVariable Long id) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404
        else {
            empleado = empleadoDtoConverter.convertDtoToEmpleado(editEmpleado, id);
            Empleado empleadoSaved = empleadoService.editar(empleado);
            return ResponseEntity.ok(empleadoSaved); // cod 200
        }
    }
    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404
        empleadoService.borrar(id);
        return ResponseEntity.noContent().build(); // cod 204
    }




}
