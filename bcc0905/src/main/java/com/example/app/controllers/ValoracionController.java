package com.example.app.controllers;

import com.example.app.entity.Valoracion;
import com.example.app.services.ValoracionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/valoracion")
public class ValoracionController {
   private ValoracionService valoracionService;

    public ValoracionController(ValoracionService valoracionService) {
        this.valoracionService = valoracionService;
    }

    @GetMapping({"/", "/list"})
    public String showList(Model model) {

        model.addAttribute("listaValoraciones", valoracionService.obtenerTodas());
        return "valoracion/valoracionView";

    }

    @GetMapping("/new")
    public String showNew(Model model) {

        model.addAttribute("valoracionForm", new Valoracion());
        return "valoracion/newValoracionForm";

    }
    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Valoracion valoracionForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("valoracionForm", new Valoracion());
            model.addAttribute("txtError", "Error en formulario");
            return "valoracion/newValoracionForm";
        }
        valoracionService.añadir(valoracionForm);
        return "redirect:/valoracion/list";
    }

    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {

        valoracionService.borrar(id);
        return "redirect:/valoracion/list";

    }
}
