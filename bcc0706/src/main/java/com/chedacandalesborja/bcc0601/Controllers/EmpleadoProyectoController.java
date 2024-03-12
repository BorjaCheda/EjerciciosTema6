package com.chedacandalesborja.bcc0601.Controllers;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Models.EmpleadoProyecto;
import com.chedacandalesborja.bcc0601.Models.Proyecto;
import com.chedacandalesborja.bcc0601.Services.EmpleadoProyectoService;
import com.chedacandalesborja.bcc0601.Services.EmpleadoService;
import com.chedacandalesborja.bcc0601.Services.ProyectoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emplProy")
public class EmpleadoProyectoController {
    @Autowired
    public EmpleadoProyectoService empleadoProyectoService;
    @Autowired
    public EmpleadoService empleadoService;
    @Autowired
    public ProyectoService proyectoService;

    @GetMapping("/emp/{id}") // lista de proyectos de un empleado
    public String showProyectsByEmpl(@PathVariable long id, Model model) {
        Empleado e = empleadoService.obtenerPorId(id);
        model.addAttribute("listaEmpleadoProyecto",
                empleadoProyectoService.obtenerPorEmpleado(e));
        model.addAttribute("empleado", e);
        return "empleadoProyecto/empListView";
    }

    @GetMapping("/proy/{id}") // lista de empleados de un proyecto
    public String showEmplbyProyect(@PathVariable long id, Model model) {
        Proyecto p = proyectoService.obtenerPorId(id);
        model.addAttribute("listaEmpleadoProyecto",
                empleadoProyectoService.obtenerPorProyecto(p));
        model.addAttribute("proyecto", p);
        return "empleadoProyecto/proListView";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteEmpl(@PathVariable long id) {
        EmpleadoProyecto EmpleadoProyectoEliminar = empleadoProyectoService.obtenerPorId(id);
        empleadoProyectoService.borrar(EmpleadoProyectoEliminar);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String showNewProjectEmpl(Model model) {
        model.addAttribute("empleadoProyectoForm", new EmpleadoProyecto());
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        model.addAttribute("listaProyectos", proyectoService.obtenerTodos());
        return "empleadoProyecto/empProyNewFormView";
    }

    @PostMapping("/new/submit")
    public String showNewProjectEmplSubmit(@Valid EmpleadoProyecto empleadoProyectoForm,
                                           BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            empleadoProyectoService.añadir(empleadoProyectoForm);
        return "redirect:/";
    }
}
