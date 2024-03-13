package com.chedacandalesborja.bcc0601.Controllers;

import com.chedacandalesborja.bcc0601.DTO.EmpleadoDTO;
import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Services.EmpleadoServiceImplBD;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpleadoController<id> {

    @Autowired
    public EmpleadoServiceImplBD empleadoService;

    @GetMapping ({"/", "/list"})
    public String showList (Model model){

        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        List<EmpleadoDTO> listaDTO = empleadoService.convertEmpleadoToDto(listaEmpleados);

        model.addAttribute("listaEmpleados", listaDTO);
        return "empleado/listView";
    }

}
