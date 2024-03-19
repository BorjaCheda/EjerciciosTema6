package com.chedacandalesborja.bcc0601.Controllers;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Services.EmpleadoServiceImplBD;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpleadoController<id> {

    @Autowired
    public EmpleadoServiceImplBD empleadoService;

    @GetMapping ({"/", "/list"})
    public String showList (Model model){
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        return "listView";
    }

    @GetMapping ("/nuevo")
    public String showNew (Model model){
        model.addAttribute("empleadoForm", new Empleado());
        return "newFormView";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit (@Valid Empleado empleadoForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "redirect:/nuevo";
        empleadoService.añadir(empleadoForm);
        return "redirect:/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm (@PathVariable long id, Model model ){
        Empleado empleado = empleadoService.obtenerPorId(id);

        if (empleado != null){
            model.addAttribute("empleadoForm", empleado);
            return "editFormView";
        }
        return "redirect:/";
    }

    @PostMapping("/editar/{id}/submit")
    public String showEditSubmit(@Valid Empleado empleadoForm, @PathVariable Long id, BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            empleadoService.editar(empleadoForm);
        return "redirect:/list";

    }
    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {
        empleadoService.borrar(id);
        return "redirect:/list";
    }

    @GetMapping("/accessError")
    public String showError() {
        return "accessError";
    }
    @GetMapping("/signin")
    public String showLogin() { return "signinView"; }
    @GetMapping("/signout")
    public String showLogout() { return "signoutView"; }

    @GetMapping("/listado1/{salario}")
    public String showListado1(@PathVariable Double salario, Model model) {
        List<Empleado> empleados = empleadoService.findBySalarioGreaterThanEqualOrderBySalario(salario);
        model.addAttribute("tituloListado", "Empleados salario mayor que: " +
                salario.toString() + "€:");
        model.addAttribute("listaEmpleados", empleados);
        return "listView";
    }
    @GetMapping("/listado2")
    public String showListado2(Model model) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadoSalarioMayorMedia();
        model.addAttribute("tituloListado", "Empleados salario mayor que la media:");
        model.addAttribute("listaEmpleados", empleados);
        return "listView";
    }
    @GetMapping("/listado3")
    public String showListado3(Model model) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadosConLetraA();
        model.addAttribute("tituloListado", "Empleados que tengan en su nombre la letra A:");
        model.addAttribute("listaEmpleados", empleados);
        return "listView";
    }






}
