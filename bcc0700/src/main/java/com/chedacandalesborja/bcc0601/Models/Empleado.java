package com.chedacandalesborja.bcc0601.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Empleado {

    @Id
    @GeneratedValue
    @Min(value = 0)
    private Long id;

    @NotEmpty
    private String nombre;

    @Email(message = "Debe tener formato email válido")
    private String email;

    private Double salario;

    private boolean enActivo;

    private Genero genero;

    //@ToString.Exclude
    //@ManyToOne
    //@JoinColumn (name="CATEGORIA_ID") //opcional
   // private Categoria categoria;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "DEPTO_ID", foreignKey = @ForeignKey(name="DEPTO_ID_FK"))
    private Departamento departamento;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Proyecto> proyectos = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.REMOVE)
    private List<EmpleadoProyecto> empleadoProyecto = new ArrayList<>();

}