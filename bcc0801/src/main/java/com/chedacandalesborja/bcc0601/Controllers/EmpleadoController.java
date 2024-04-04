package com.chedacandalesborja.bcc0601.Controllers;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Services.EmpleadoServiceImplBD;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    public EmpleadoServiceImplBD empleadoService;

    @GetMapping("/empleado")
    public ResponseEntity<?> getList() {
        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        if (listaEmpleados.isEmpty())
            return ResponseEntity.notFound().build(); // cod 404
        else
            return ResponseEntity.ok(listaEmpleados); // cod 200
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
    public ResponseEntity<?> newElement(@Valid @RequestBody Empleado nuevoEmpleado) {
        //@Valid si no se cumple la validación devuelve BAD_REQUEST cod 400
        Empleado empleado = empleadoService.añadir(nuevoEmpleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado); // cod 201
    }
    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> editElement(@Valid @RequestBody Empleado editEmpleado,
                                         @PathVariable Long id) {
        //@Valid si no se cumple la validación devuelve BAD_REQUEST cod 400
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404
        else {
            empleado = empleadoService.editar(editEmpleado);
            return ResponseEntity.ok(empleado); // cod 200
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
