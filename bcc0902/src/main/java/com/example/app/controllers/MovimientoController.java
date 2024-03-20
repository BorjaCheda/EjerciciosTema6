package com.example.app.controllers;


import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import com.example.app.services.CuentaService;
import com.example.app.services.MovimientoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping({"/movimiento"})
@Controller
public class MovimientoController {

    @Autowired
    public MovimientoService movimientoService;
    @Autowired
    public CuentaService cuentaService;

    @GetMapping({"/", "/list", ""})
    public String showList(Model model) {
        model.addAttribute("listaMovimientos", movimientoService.obtenerTodos());
        return "/movimiento/movimientoView";
    }

    @GetMapping("/{IBAN}")
    public String showListInMovimiento(@PathVariable String IBAN, Model model) {
        model.addAttribute("listaMovimientos", movimientoService.findMovimientoByIBAN(IBAN));
        model.addAttribute("saldoActual", cuentaService.obtenerPorIBAN(IBAN).getSaldo());

        return "/movimiento/movimientoView";
    }

    @GetMapping("/nuevo/{IBAN}")
    public String showNew(@PathVariable String IBAN, Model model) {

        model.addAttribute("movimientoForm", new Movimiento(IBAN));
        model.addAttribute("saldoActual", cuentaService.obtenerPorIBAN(IBAN).getSaldo());

        return "/movimiento/newMovimientoForm";

    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(@Valid Movimiento movimientoForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "/movimiento/error";
        cuentaService.modificarSaldo(movimientoForm);
        return "redirect:/movimiento/" + movimientoForm.getIBAN();
    }
}


