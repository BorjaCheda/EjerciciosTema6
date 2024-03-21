package com.example.app.controllers;


import com.example.app.entity.Cuenta;
import com.example.app.entity.Usuario;
import com.example.app.services.CuentaService;
import com.example.app.services.MovimientoService;
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

@RequestMapping({"/usuario"})
@Controller
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping({"/", "/list", ""})
    public String showList(Model model) {

        model.addAttribute("listaUsuarios", usuarioService.obtenerTodos());
        return "usuario/usuarioView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        model.addAttribute("usuarioForm", new Usuario());
        return "/usuario/newUsuarioForm";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(@Valid Usuario usuarioForm, BindingResult bindingResult) {

        Integer sizeUsuarios = usuarioService.obtenerTodos().size(); // Cogemos el tamaño de la Lista de Usuarios

        if (bindingResult.hasErrors()) return "/usuario/error";

        usuarioService.agregar(usuarioForm);

        // En este If comprobamos que el tamaño sea el mismo de antes por si no se ha añadido ese usuario por algún motivo
        // Ese motivo sería que el nombre está repetido.
        if (sizeUsuarios == usuarioService.obtenerTodos().size()) return "/usuario/error";

        return "redirect:/usuario/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        model.addAttribute("usuarioForm", usuarioService.obtenerPorId(id));

        return "/usuario/editUsuario";
    }

    @PostMapping("/editar/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Usuario usuarioForm) {

        usuarioService.editar(usuarioForm);

        return "redirect:/usuario/";
    }

    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable Long id) {

        usuarioService.borrar(id);

        return "redirect:/usuario/";
    }
}
