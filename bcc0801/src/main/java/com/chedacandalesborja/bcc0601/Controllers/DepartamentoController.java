package com.chedacandalesborja.bcc0601.Controllers;

import com.chedacandalesborja.bcc0601.Models.Departamento;
import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Services.DepartamentoService;
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
@RequestMapping("/depto")
public class DepartamentoController {

    @Autowired
    public DepartamentoService departamentoService;

    @GetMapping("")
    public ResponseEntity<?> getList() {
        List<Departamento> listaDepartamento = departamentoService.obtenerTodos();
        if (listaDepartamento.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(listaDepartamento);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneElement(@PathVariable Long id) {
        Departamento departamento = departamentoService.obtenerPorId(id);
        if (departamento == null)
            return ResponseEntity.notFound().build(); // cod 404
        else
            return ResponseEntity.ok(departamento); // cod 200
    }
    @PostMapping("")
    public ResponseEntity<?> newElement(@RequestBody Departamento nuevoDepartamento) {
        //@Valid si no se cumple la validación devuelve BAD_REQUEST cod 400
        Departamento departamento = departamentoService.añadir(nuevoDepartamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamento); // cod 201
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editElement(@RequestBody Departamento editDepartamento,
                                         @PathVariable Long id) {
        //@Valid si no se cumple la validación devuelve BAD_REQUEST cod 400
        Departamento departamento = departamentoService.obtenerPorId(id);
        if (departamento == null)
            return ResponseEntity.notFound().build(); // cod 404
        else {
            departamento = departamentoService.editar(editDepartamento);
            return ResponseEntity.ok(departamento); // cod 200
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        Departamento departamento = departamentoService.obtenerPorId(id);
        if (departamento == null)
            return ResponseEntity.notFound().build(); // cod 404
        departamentoService.borrar(id);
        return ResponseEntity.noContent().build(); // cod 204
    }
}
