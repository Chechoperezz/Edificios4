package Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "edificios")
@Data
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double metrosCuadrados;
    private Double altura;
    private Integer numPisos;
    private Integer numApartamentos;
    private Integer numOficinas;
    private String nomParqueadero;
    private Integer numPiscinas;
    private String pais;
    private String departamento;
    private String ciudad;
    private Boolean tieneAscensor;
    private Double valorAdministracion;
    private Boolean tieneZonaSocial;
}