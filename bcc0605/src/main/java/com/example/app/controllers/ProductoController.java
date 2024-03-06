package com.example.app.controllers;

import com.example.app.entity.Categoria;
import com.example.app.entity.Producto;
import com.example.app.services.CategoriaService;
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

    @Autowired
    public CategoriaService categoriaService;

    @GetMapping({"/", "/list"})
    public String showList(Model model) {

        model.addAttribute("listaProductos", productoService.obtenerTodos());
        model.addAttribute("listaCategorias", categoriaService.obtenerTodas());
        model.addAttribute("categoriaSeleccionada", new Categoria (0L,"Todas"));
        return "producto/productoView";

    }

    @GetMapping("/new")
    public String showNew(Model model) {

        model.addAttribute("productForm", new Producto());
        model.addAttribute("listaCategorias", categoriaService.obtenerTodas());
        return "producto/newProductoForm";

    }
    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Producto productoForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("productoForm", new Producto());
            model.addAttribute("listaCategorias", categoriaService.obtenerTodas());
            model.addAttribute("txtError", "Error en formulario");
            return "producto/newProductoForm";
        }
        productoService.añadir(productoForm);
        return "redirect:/producto/list";
    }
    @GetMapping("/porCateg/{idCat}")
    public String showListInCategory(@PathVariable Long idCat, Model model) {
        model.addAttribute("listaProductos", productoService.findByCategory(idCat));
        model.addAttribute("listaCategorias", categoriaService.obtenerTodas());
        model.addAttribute("categoriaSeleccionada", categoriaService.obtenerPorId(idCat));
        return "producto/productoView";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        Producto productoAEditar = productoService.obtenerPorId(id);

        model.addAttribute("productForm", productoAEditar);
        model.addAttribute("listaCategorias", categoriaService.obtenerTodas());

        return "producto/editProducto";
    }
    @PostMapping("/editar/{id}/submit")
    public String showEditSubmit(@Valid Producto productForm, @PathVariable Long id) {

       Producto productoEditado = productoService.editar(productForm);

        System.out.println("Id: " + productoEditado.getId() + " Precio nuevo: " + productoEditado.getPrecio());
        return "redirect:/producto/";
    }

    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {

        productoService.borrar(id);
        return "redirect:/producto/list";

    }
}
