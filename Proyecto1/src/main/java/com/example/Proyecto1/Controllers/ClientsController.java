package com.example.Proyecto1.Controllers;

import com.example.Proyecto1.Models.Clients;
import com.example.Proyecto1.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientsController {
    @Autowired
    ClientRepository clientsRepository;

    @GetMapping("/formulario")
    public String getForm(Model model) {
        /*
        acciones de controlador
         */


        Clients clients = new Clients();

        model.addAttribute("cliente", clients);

        return "formBase.html";
    }

    @PostMapping("/postForm")
    public String postForm(@ModelAttribute("cliente") Clients clients, Model model) {

        clientsRepository.save(clients);

        List<Clients> listaclientes = clientsRepository.findAll();
        model.addAttribute("listaempleados", listaclientes);


        return "listEmployees.html";
    }
}

@Controller
class NumerosController {

    int random = (int) (Math.random() * 100);
    public ArrayList<Integer> lista = new ArrayList<>();

    @GetMapping("/listanumeros")
    public String showList (Model model){

        model.addAttribute("tamanoLista", lista.size());
        model.addAttribute("listaNumeros", lista);
        return "numeros.html";
    }

    @GetMapping("/nuevoNumero")
    public String nuevoNumero(){

        lista.add(random);
        return "redirect:/listanumeros";

    }
    @GetMapping("/numeroEliminado{id}")
    public String numeroEliminado(@PathVariable Integer id){

        lista.remove(id);
        return "redirect:/listanumeros";

    }

}