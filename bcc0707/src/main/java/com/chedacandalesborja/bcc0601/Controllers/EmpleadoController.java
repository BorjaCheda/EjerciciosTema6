package com.chedacandalesborja.bcc0601.Controllers;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Services.EmpleadoService;
import com.chedacandalesborja.bcc0601.Services.EmpleadoServiceImplBD;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/listaEmpleados")
public class EmpleadoController<id> {

    @Autowired
    public EmpleadoService empleadoService;
    @GetMapping("/")
    public String showList(@RequestParam(required = false) Integer pag, Model model) {
        int ultPag = empleadoService.getTotalPaginas() - 1;
        if (pag == null || pag < 0 || pag > ultPag) pag = 0;
        Integer pagSig = ultPag > pag ? pag + 1 : ultPag;
        Integer pagAnt = pag > 0 ? pag - 1 : 0;
        System.out.println("Las páginas totales de esta base de datos dividas de 10 en 10 son: " + empleadoService.getTotalPaginas());
        model.addAttribute("listaEmpleados", empleadoService.getEmpleadosPaginados(pag));
        model.addAttribute("pagSiguiente", pagSig);
        model.addAttribute("pagAnterior", pagAnt);
        model.addAttribute("pagFinal", ultPag);
        return "listView";
    }





}
