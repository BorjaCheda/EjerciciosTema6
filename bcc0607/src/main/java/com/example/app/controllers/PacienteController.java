
package com.example.app.controllers;


import com.example.app.entity.Paciente;
import com.example.app.entity.PacienteDTO;
import com.example.app.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping({"/paciente"})
@Controller
public class PacienteController {
    @Autowired
    public PacienteService pacienteService;

    @GetMapping({"/", "/home"})
    public String showList(Model model) {
        model.addAttribute("listaPacientes", pacienteService.findAll());
        model.addAttribute("factura", 0);
        return "pacienteView";
    }

    @GetMapping("/nuevoPaciente")
    public String showNew(Model model) {
        model.addAttribute("nuevoPaciente", new PacienteDTO());
        return "newPacienteForm";
    }

    @PostMapping("/nuevoPaciente/submit")
    public String showNewSubmit(@Valid PacienteDTO nuevoPacienteDTO, BindingResult bindingResult) {
           System.out.println((nuevoPacienteDTO.getDNI()));
            Paciente nuevoPaciente = pacienteService.buildPacienteFromDTO(nuevoPacienteDTO);
            System.out.println(nuevoPaciente.getDNI());
            pacienteService.add(nuevoPaciente);
            return "redirect:paciente/home";

    }

    @GetMapping("/llamar")
    public String showDelete(Model model) {
        Paciente paciente=pacienteService.getFirst();
        Integer factura=0;
        if(paciente != null){
            factura=pacienteService.facturar(paciente);
            pacienteService.deleteFirst();
        }
        model.addAttribute("listaPacientes",pacienteService.findAll());
        model.addAttribute("factura",factura);
        return "pacienteView";

    }
}

