package com.example.app.controllers;

import com.example.app.entity.Usuario;
import com.example.app.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping({"/", "/list"})
    public String showList(Model model) {

        model.addAttribute("listaUsuarios", usuarioService.obtenerTodos());
        return "usuario/usuarioView";

    }

    @GetMapping("/new")
    public String showNew(Model model) {

        model.addAttribute("usuarioForm", new Usuario());
        return "usuario/newUsuarioForm";

    }
    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Usuario usuarioForm) {

        usuarioForm.setFechaRegistro(LocalDate.now());
        usuarioService.añadir(usuarioForm);
        return "redirect:/usuario/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {

        Usuario usuarioAEditar = usuarioService.obtenerPorId(id);
        model.addAttribute("usuarioForm", usuarioAEditar);
        return "usuario/editUsuario";
    }
    @PostMapping("/editar/{id}/submit")
    public String showEditSubmit(@Valid Usuario usuarioForm, @PathVariable Long id, BindingResult bindingResult) {

        usuarioForm.setFechaRegistro(LocalDate.now());
        System.out.println(usuarioForm.getId());
        System.out.println(usuarioForm.getNombre());
        System.out.println(usuarioForm.getFechaRegistro());

        usuarioService.editar(usuarioForm);
        return "redirect:/usuario/";
    }
    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {

        usuarioService.borrar(id);
        return "redirect:/usuario/list";

    }
}
