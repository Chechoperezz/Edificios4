package com.udc.edificios3.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cedula;
    private String nombre;
    private String email;
    private String password;
    private String preguntaSeguridad;
    private String respuestaSeguridad;

}
