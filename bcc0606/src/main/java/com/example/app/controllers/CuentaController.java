package com.example.app.controllers;


import com.example.app.entity.Cuenta;
import com.example.app.services.MovimientoService;
import com.example.app.services.CuentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping({"/cuenta"})
@Controller
public class CuentaController {

    @Autowired
    public CuentaService cuentaService;
    @Autowired
    public MovimientoService movimientoService;

    @GetMapping({"/", "/list", ""})
    public String showList(@RequestParam(required = false) Integer err, Model model) {

        model.addAttribute("listaCuentas", cuentaService.obtenerTodos());
        model.addAttribute("listaMovimientos", movimientoService.obtenerTodos());
        return "cuenta/cuentaView";
    }

    @GetMapping("/list/{idMov}")
    public String showListMovimientos(@PathVariable Long idMov, Model model) {

        model.addAttribute("listaCuentas", cuentaService.findByMovimiento(idMov));
        model.addAttribute("listaMovimientos", movimientoService.obtenerTodos());
        model.addAttribute("movimientoSeleccionado", movimientoService.obtenerPorId(idMov));

        return "/cuenta/cuentaView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {

        model.addAttribute("cuentaForm", new Cuenta());
        model.addAttribute("listaMovimientos", movimientoService.obtenerTodos());
        return "/cuenta/newCuentaForm";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(@Valid Cuenta cuentaForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) return "/cuenta/error";

        cuentaService.agregar(cuentaForm);

        return "redirect:/cuenta/list";
    }

    @GetMapping("/editar/{IBAN}")
    public String showEditForm(@PathVariable String IBAN, Model model) {

        Cuenta cuentaAEditar = cuentaService.obtenerPorIBAN(IBAN);

        model.addAttribute("cuentaForm", cuentaAEditar);

        return "/cuenta/editCuenta";
    }

    @PostMapping("/editar/{IBAN}/submit")
    public String showEditSubmit(@PathVariable String IBAN, @Valid Cuenta cuentaForm, Model model, BindingResult bindingResult) {

        cuentaService.editar(cuentaForm);

        return "redirect:/cuenta/";
    }

    @GetMapping("/borrar/{IBAN}")
    public String showDelete(@PathVariable String IBAN, Model model) {

        cuentaService.borrar(IBAN);

        return "redirect:/cuenta/";
    }
}

