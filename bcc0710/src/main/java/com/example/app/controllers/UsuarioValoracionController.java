package com.example.app.controllers;

import com.example.app.entity.Usuario;
import com.example.app.entity.UsuarioValoracion;
import com.example.app.services.*;
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
@RequestMapping("/usuValor")
public class UsuarioValoracionController {
    @Autowired
    public UsuarioValoracionService usuarioValoracionService;
    @Autowired
    public ProductoValoracionService productoValoracionService;

    @Autowired
    public UsuarioService usuarioService;

    @Autowired
    public ValoracionService valoracionService;
   @Autowired
   public ProductoService productoService;

    @GetMapping("/usu/{id}") // lista de valoraciones de un usuario
    public String showValorationsByUsu(@PathVariable long id, Model model) {
        Usuario u = usuarioService.obtenerPorId(id);
        model.addAttribute("listaUsuarioValoracion", usuarioValoracionService.obtenerPorUsuario(u));
        model.addAttribute("usuario", u);
        return "usuarioValoracion/usuarioValoracionView";
    }

    @GetMapping("/borrar/{id}")
    public String showDeleteUsu(@PathVariable long id) {
        usuarioValoracionService.borrar(usuarioValoracionService.obtenerPorId(id));
        return "redirect:/usuario/";
    }

    @GetMapping("/new")
    public String showNewUsuValor(Model model) {
        model.addAttribute("usuarioValoracionForm", new UsuarioValoracion());
        model.addAttribute("listaUsuarios", usuarioService.obtenerTodos());
        model.addAttribute("listaValoraciones", valoracionService.obtenerTodas());
        model.addAttribute("listaProductos", productoService.obtenerTodos());
        return "usuarioValoracion/newUsuarioValoracionForm";
    }
    @PostMapping("/new/submit")
    public String showNewUsuarioValoracionSubmit(@Valid UsuarioValoracion usuarioValoracionForm,
                                                  BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            System.out.println(("Aqui no entras???"));
            usuarioValoracionService.añadir(usuarioValoracionForm);
        return "redirect:/usuario/list";
    }
}
