package com.itp.ingsoftII.restaurante.entidad;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario", schema = "itp-soft-2")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo", nullable = false, length = 90)
    private String correo;
}