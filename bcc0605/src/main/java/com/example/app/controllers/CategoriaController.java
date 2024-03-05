package com.example.app.controllers;

import com.example.app.entity.Categoria;
import com.example.app.entity.Producto;
import com.example.app.services.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    public CategoriaService categoriaService;

    @GetMapping({"/", "/list"})
    public String showList(Model model) {

        model.addAttribute("listaCategorias", categoriaService.obtenerTodas());
        return "categoria/categoriaView";

    }

    @GetMapping("/new")
    public String showNew(Model model) {

        model.addAttribute("categoriaForm", new Categoria());
        return "categoria/newCategoriaForm";

    }
    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Categoria categoriaForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categoriaForm", new Categoria());
            model.addAttribute("txtError", "Error en formulario");
            return "categoria/newCategoriaForm";
        }
        categoriaService.añadir(categoriaForm);
        return "redirect:/categoria/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {

        Categoria categoriaAEditar = categoriaService.obtenerPorId(id);

        model.addAttribute("categoriaForm", categoriaAEditar);
        return "categoria/editCategoria";
    }
    @PostMapping("/editar/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Categoria categoriaForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) return "redirect:/?err=1";

        categoriaService.editar(categoriaForm);
        return "redirect:/categoria/";
    }
    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {

        categoriaService.borrar(id);
        return "redirect:/categoria/list";

    }


}
