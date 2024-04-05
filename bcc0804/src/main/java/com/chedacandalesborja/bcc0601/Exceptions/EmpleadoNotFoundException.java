package com.chedacandalesborja.bcc0601.Exceptions;

public class EmpleadoNotFoundException extends RuntimeException {
    public EmpleadoNotFoundException(Long id) {
        super("No se puede encontrar empleado con ID: " + id);
    }
}