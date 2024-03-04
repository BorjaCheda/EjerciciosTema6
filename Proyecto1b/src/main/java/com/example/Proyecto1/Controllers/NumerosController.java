package com.example.Proyecto1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class NumerosController {
    public ArrayList<Integer> lista;


    public NumerosController() {
        lista = new ArrayList<>();

    }

    @GetMapping("/listanumeros")
    public String showList(Model model) {

        model.addAttribute("tamanoLista", lista.size());
        model.addAttribute("listaNumeros", lista);
        return "numeros.html";
    }

    @GetMapping("/nuevoNumero")
    public String nuevoNumero() {

        int random = (int) (Math.random() * 100);
        lista.add(random);

        return "redirect:/listanumeros";

    }

    @GetMapping("/numeroEliminado{id}")
    public String numeroEliminado(@PathVariable Integer id) {

        lista.remove(id);

        return "redirect:/listanumeros";

    }

}
