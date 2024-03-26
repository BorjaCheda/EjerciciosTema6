package com.example.app.controllers;

import com.example.app.entity.Producto;
import com.example.app.entity.ProductoValoracion;
import com.example.app.entity.Usuario;
import com.example.app.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
@RequestMapping("/prodVal")
public class ProductoValoracionController {
    @Autowired
    public ProductoValoracionService productoValoracionService;

    @Autowired
    public ProductoService productoService;

    @Autowired
    public ValoracionService valoracionService;

    @GetMapping("/prod/{id}") // lista de valoraciones de un producto
    public String showValorationsByProd(@PathVariable long id, Model model) {
        Producto p = productoService.obtenerPorId(id);

        model.addAttribute("listaProductoValoracion", productoValoracionService.obtenerPorProducto(p));
        model.addAttribute("producto", p);

        return "productoValoracion/productoValoracionView";
    }

    @GetMapping("/borrar/{id}")
    public String showDeleteProd(@PathVariable long id) {
        productoValoracionService.borrar(productoValoracionService.obtenerPorId(id));
        return "redirect:/producto/";
    }

    @GetMapping("/new")
    public String showNewProdValor(Model model) {
        model.addAttribute("productoValoracionForm", new ProductoValoracion());
        model.addAttribute("listaProductos", productoService.obtenerTodos());
        model.addAttribute("listaValoraciones", valoracionService.obtenerTodas());
        return "productoValoracion/newProductoValoracionForm";
    }
    @PostMapping("/new/submit")
    public String showNewProductoValoracionSubmit(@Valid ProductoValoracion productoValoracionForm,
                                           BindingResult bindingResult) {
        System.out.println(productoValoracionForm);
        if (!bindingResult.hasErrors())
            productoValoracionService.añadir(productoValoracionForm);
        return "redirect:/producto/";
    }
}
