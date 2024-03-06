package com.example.app.controllers;


import com.example.app.entity.Movimiento;
import com.example.app.services.CuentaService;
import com.example.app.services.MovimientoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RequestMapping({"/movimiento"})
@Controller
public class MovimientoController {

    @Autowired
    public MovimientoService movimientoService;
    @Autowired
    public CuentaService cuentaService;

    @GetMapping({"/", "/list",""})
    public String showList(@RequestParam(required = false) Integer err, Model model) {
        return "/cuenta/cuentaView";
    }

    @GetMapping("/{IBAN}")
    public String showListInMovimiento(@PathVariable String IBAN, Model model) {
        return "/cuenta/cuentaView";
    }

    @GetMapping("/nuevo/{IBAN}")
    public String showNew(@PathVariable String IBAN,Model model){
        return "/cuenta/cuentaView";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(@Valid Movimiento movimientoForm, BindingResult bindingResult, Model model){
        return "/cuenta/cuentaView";
    }
}


