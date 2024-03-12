package com.chedacandalesborja.bcc0601.Repositories;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findBySalarioGreaterThanEqualOrderBySalario (double salario);

    @Query("select e from Empleado e " +
            "where e.salario > (select avg (e2.salario) from Empleado e2)")
    List <Empleado> obtenerEmpleadoSalarioMayorMedia();

    @Query("SELECT e from Empleado e where e.nombre LIKE '%a%'")
    List <Empleado> obtenerEmpleadosConLetraA();

    //List<Empleado> findByDepartamento (Long idDepartamento);
    List<Empleado> findEmpleadosByDepartamentoId (Long idDepartamento);
}
