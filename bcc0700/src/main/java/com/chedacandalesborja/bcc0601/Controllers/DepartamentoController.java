package com.chedacandalesborja.bcc0601.Controllers;

import com.chedacandalesborja.bcc0601.Models.Departamento;
import com.chedacandalesborja.bcc0601.Services.DepartamentoService;
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
@RequestMapping("/depto")
public class DepartamentoController {
    private final DepartamentoService departamentoService;
    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
        return "listDepartamentoView";
    }
    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("departamentoForm", new Departamento());
        return "newFormDepartamentoView";
    }
    @PostMapping("/new/submit")
    public String showNewSubmit( @Valid Departamento departamentoForm,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/depto/new";

        departamentoService.añadir(departamentoForm);
        return "redirect:/depto/list";
    }
    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        departamentoService.borrar(departamentoService.obtenerPorId(id));
        return "redirect:/depto/list";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Departamento departamento = departamentoService.obtenerPorId(id);
        if (departamento != null) {
            model.addAttribute("departamentoForm", departamento);
            return "editFormDepartamentoView";
        }
        return "redirect:/depto/list";
    }
    @PostMapping("/edit/{id}/submit")
    public String showEditSubmit( @Valid Departamento departamentoForm,
                                  BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            departamentoService.editar(departamentoForm);
        return "redirect:/depto/list";
    }
}