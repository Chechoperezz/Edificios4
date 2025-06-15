package com.udc.edificios3.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double metrosCuadrados;
    private double altura;
    private int numPisos;
    private int numApartamentos;
    private int numOficinas;
    private String nomParqueadero;
    private int numPiscinas;
    private String pais;
    private String departamento;
    private String ciudad;
    private boolean tieneAsensor;
    private double valorAdministracion;
    private boolean tienzonaSocial;
}
