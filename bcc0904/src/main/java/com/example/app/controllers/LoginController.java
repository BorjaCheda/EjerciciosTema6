package com.example.app.controllers;

import com.example.app.entity.Rol;
import com.example.app.entity.Usuario;
import com.example.app.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class LoginController {
    private UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping({"/login", "/signin"})
    public String showLogin() {
        return "signinView";
    }

    @GetMapping({"/signout", "/logout"})
    public String showLogout() {
        return "signoutView";
    }

    @GetMapping("/accessError")
    public String accessError() {
        return "accessError";
    }

    @GetMapping({"/registro/nuevo/"})
    public String newUser(Model model) {
        model.addAttribute("usuarioForm", new Usuario());
        return "newUser";
    }

    @PostMapping("/registro/nuevo/submit")
    public String showNewSubmit(@Valid Usuario usuarioForm) {

        if (usuarioService.findByNombre(usuarioForm.getNombre()) != null) {
            return "userDuplicated";
        }
        usuarioForm.setRol(Rol.valueOf("USER"));
        usuarioForm.setFechaRegistro(LocalDate.now());
        usuarioService.añadir(usuarioForm);
        return "redirect:/producto/list";
    }
}
