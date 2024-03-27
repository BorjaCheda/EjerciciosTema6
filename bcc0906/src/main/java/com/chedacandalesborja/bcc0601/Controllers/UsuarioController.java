package com.chedacandalesborja.bcc0601.Controllers;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Models.Usuario;
import com.chedacandalesborja.bcc0601.Services.EmpleadoServiceImplBD;
import com.chedacandalesborja.bcc0601.Services.UsuarioServiceImplBD;
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
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    public UsuarioServiceImplBD usuarioService;

    @GetMapping({"/", "/list"})
    public String showList (Model model){
        model.addAttribute("listaUsuarios", usuarioService.obtenerTodos());
        return "usuario/listView";
    }

    @GetMapping ("/nuevo")
    public String showNew (Model model){
        model.addAttribute("usuarioForm", new Usuario());
        return "usuario/newFormView";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit (@Valid Usuario usuarioForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "redirect:/nuevo";
        }

        if (usuarioService.findByNombre(usuarioForm.getNombre()) != null){
            return "userDuplicated";
        }

        usuarioService.añadir(usuarioForm);
        return "redirect:/usuario/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm (@PathVariable Long id, Model model ){
        Usuario usuario = usuarioService.obtenerPorId(id);

        if (usuario!= null){
            model.addAttribute("usuarioForm", usuario);
            return "usuario/editFormView";
        }

        return "redirect:/usuario/";
    }

    @PostMapping("/editar/{id}/submit")
    public String showEditSubmit(@Valid Usuario usuarioForm, @PathVariable Long id) {

        if (usuarioService.findByNombre(usuarioForm.getNombre()) != null){
            return "userDuplicated";
        }
        usuarioService.editar(usuarioForm);
        return "redirect:/usuario/list";

    }
    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable Long id) {
        usuarioService.borrar(id);
        return "redirect:/usuario/list";
    }
}
