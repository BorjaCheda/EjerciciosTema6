package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServiceImplBD implements EmpleadoService{
    @Autowired
    EmpleadoRepository empleadoRepository;
    private final Integer pageSize = 10;
    @Override
    public List<Empleado> getEmpleadosPaginados(Integer pageNum) {
        Pageable paging = PageRequest.of(pageNum, pageSize, Sort.by("nombre"));
        Page<Empleado> pagedResult = empleadoRepository.findAll(paging);
        if (pagedResult.hasContent()) return pagedResult.getContent();
        else return null;
    }

    @Override
    public int getTotalPaginas() {
        Pageable paging = PageRequest.of(0, pageSize, Sort.by("nombre"));
        Page<Empleado> pagedResult = empleadoRepository.findAll(paging);
        return pagedResult.getTotalPages();
    }
}
