package com.chedacandalesborja.bcc0601.Controllers;

import com.chedacandalesborja.bcc0601.Models.Proyecto;
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
@RequestMapping("/proy")
public class ProyectoController {

    @Autowired
    public ProyectoService proyectoService;

    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaProyectos", proyectoService.obtenerTodos());
        return "proyecto/listView";
    }
    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("proyectoForm", new Proyecto());
        return "proyecto/newFormView";
    }
    @PostMapping("/new/submit")
    public String showNewSubmit( @Valid Proyecto proyectoForm,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/depto/new";

        proyectoService.añadir(proyectoForm);
        return "redirect:/proy/list";
    }
    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        proyectoService.borrar(proyectoService.obtenerPorId(id));
        return "redirect:/proy/list";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Proyecto proyecto = proyectoService.obtenerPorId(id);
        if (proyecto != null) {
            model.addAttribute("proyectoForm", proyecto);
            return "proyecto/editFormView";
        } else {
            return "redirect:/proy/list";
        }
    }
    @PostMapping("/edit/{id}/submit")
    public String showEditSubmit( @Valid Proyecto proyectoForm,
                                  BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            proyectoService.editar(proyectoForm);
        return "redirect:/proy/list";
    }
}