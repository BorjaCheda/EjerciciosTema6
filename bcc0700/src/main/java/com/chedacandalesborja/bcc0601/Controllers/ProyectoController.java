package com.chedacandalesborja.bcc0601.Controllers;

import com.chedacandalesborja.bcc0601.Models.Departamento;
import com.chedacandalesborja.bcc0601.Models.Proyecto;
import com.chedacandalesborja.bcc0601.Services.DepartamentoService;
import com.chedacandalesborja.bcc0601.Services.ProyectoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/proy")
public class ProyectoController {
    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }


    @GetMapping({"/", "/list"})
    public String showList(Model model) {
        model.addAttribute("listaProyectos", proyectoService.obtenerTodos());
        return "listProyectoView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("proyectoForm", new Proyecto());
        return "newFormProyectotoView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Proyecto proyectoForm,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/proyecto/new";

        proyectoService.añadir(proyectoForm);
        return "redirect:/proy/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        proyectoService.borrar(proyectoService.obtenerPorId(id));
        return "redirect:/proy/list";
    }

}