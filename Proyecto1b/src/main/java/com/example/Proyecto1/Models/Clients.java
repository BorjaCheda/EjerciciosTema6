package com.example.Proyecto1.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Entity
@Data // Con esto ya creamos los getters, setters, toString...de cada atributo.
@Table
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String name;

    @Column
    String dni;
}
