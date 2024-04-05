package com.chedacandalesborja.bcc0601.Exceptions;

public class EmptyEmpleadosException extends RuntimeException{
    public EmptyEmpleadosException(){
        super("No hay empleados en el sistema");
    }
}
