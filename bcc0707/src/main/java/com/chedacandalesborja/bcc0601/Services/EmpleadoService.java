package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Empleado;

import java.util.List;

public interface EmpleadoService {
    List<Empleado> getEmpleadosPaginados(Integer pageNum);
    int getTotalPaginas();


}
