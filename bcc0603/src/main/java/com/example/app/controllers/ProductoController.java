package com.example.app.controllers;

import com.example.app.entity.Producto;
import com.example.app.services.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    public ProductoService productoService;

    @GetMapping({"/", "/list"})
    public String showList(Model model) {

        model.addAttribute("listaProductos", productoService.obtenerTodos());
        return "productoView";

    }

    @GetMapping("/new")
    public String showNew(Model model) {

        model.addAttribute("productForm", new Producto());
        return "newProductoForm";

    }
    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Producto productoForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("productoForm", new Producto());
            model.addAttribute("txtError", "Error en formulario");
            return "newProductoForm";
        }
        productoService.añadir(productoForm);
        return "redirect:/producto/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {

        Producto productoAEditar = productoService.obtenerPorId(id);

        model.addAttribute("productForm", productoAEditar);
        return "editProducto";
    }
    @PostMapping("/editar/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Producto productoForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) return "redirect:/?err=1";

        productoService.editar(productoForm);
        return "redirect:/producto/";
    }
    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {

        productoService.borrar(id);
        return "redirect:/producto/list";

    }
}
