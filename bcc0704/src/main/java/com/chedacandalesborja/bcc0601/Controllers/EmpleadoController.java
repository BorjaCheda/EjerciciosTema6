package com.chedacandalesborja.bcc0601.Controllers;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Services.CategoriaService;
import com.chedacandalesborja.bcc0601.Services.DepartamentoService;
import com.chedacandalesborja.bcc0601.Services.EmpleadoServiceImplBD;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpleadoController<id> {

    @Autowired
    public EmpleadoServiceImplBD empleadoService;
    @Autowired
    public DepartamentoService departamentoService;
    @Autowired
    public CategoriaService categoriaService;

    @GetMapping ({"/", "/list"})
    public String showList (Model model){
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        model.addAttribute("listaDepartamentos",departamentoService.obtenerTodos());
        model.addAttribute("listaCategorias",categoriaService.obtenerTodos());
        model.addAttribute("deptoSeleccionado", 0);
        model.addAttribute("categoriaSeleccionada", 0);
        return "empleado/listView";
    }

    @GetMapping ("/nuevo")
    public String showNew (Model model){
        model.addAttribute("empleadoForm", new Empleado());
        model.addAttribute("listaDepartamentos",departamentoService.obtenerTodos());
        model.addAttribute("listaCategorias",categoriaService.obtenerTodos());
        return "empleado/newFormView";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit (@Valid Empleado empleadoForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "redirect:/nuevo";
        empleadoService.añadir(empleadoForm);
        return "redirect:/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm (@PathVariable long id, Model model ){
        Empleado empleado = empleadoService.obtenerPorId(id);
        model.addAttribute("listaDepartamentos",departamentoService.obtenerTodos());
        model.addAttribute("listaCategorias",categoriaService.obtenerTodos());
        if (empleado != null){
            model.addAttribute("empleadoForm", empleado);
            return "empleado/editFormView";
        }
        return "redirect:/";
    }

    @PostMapping("/editar/{id}/submit")
    public String showEditSubmit(@Valid Empleado empleadoForm, @PathVariable Long id, BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            empleadoService.editar(empleadoForm);
        return "redirect:/list";

    }
    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {
        empleadoService.borrar(id);
        return "redirect:/list";
    }

    @GetMapping("/listado1/{salario}")
    public String showListado1(@PathVariable Double salario, Model model) {
        List<Empleado> empleados = empleadoService.findBySalarioGreaterThanEqualOrderBySalario(salario);
        model.addAttribute("tituloListado", "Empleados salario mayor que: " +
                salario.toString() + "€:");
        model.addAttribute("listaEmpleados", empleados);
        return "empleado/listView";
    }
    @GetMapping("/listado2")
    public String showListado2(Model model) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadoSalarioMayorMedia();
        model.addAttribute("tituloListado", "Empleados salario mayor que la media:");
        model.addAttribute("listaEmpleados", empleados);
        return "empleado/listView";
    }
    @GetMapping("/listado3")
    public String showListado3(Model model) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadosConLetraA();
        model.addAttribute("tituloListado", "Empleados que tengan en su nombre la letra A:");
        model.addAttribute("listaEmpleados", empleados);
        return "empleado/listView";
    }
    @GetMapping ("/porDepto/{idDepartamento}")
    public String showEmpleadosPorDepartamento (@PathVariable Long idDepartamento, Model model){

        List<Empleado> empleadosPorDepartamento = empleadoService.findEmpleadosByDepartamentoId(idDepartamento);
        model.addAttribute("listaEmpleados", empleadosPorDepartamento);
        model.addAttribute("tituloListado", "Estas mostrando los empleados del departamento de " +
                departamentoService.obtenerPorId(idDepartamento).getNombre() + ":");
        model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        return "empleado/listView";
    }
    @GetMapping ("/porCategoria/{idCategoria}")
    public String showEmpleadosPorCategoria (@PathVariable Long idCategoria, Model model){

        List<Empleado> empleadosPorCategoria = empleadoService.findEmpleadosByCategoriaId(idCategoria);
        model.addAttribute("listaEmpleados", empleadosPorCategoria);
        model.addAttribute("tituloListado", "Estas mostrando los empleados de la categoría de " +
                categoriaService.obtenerPorId(idCategoria).getNombre()+ ":");
        model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        return "empleado/listView";
    }





}
