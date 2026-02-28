package com.Becas.Utn.Model;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "convocatoria", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"beca_id", "anio"})
})
public class Convocatoria {
    //Creacion de atributos de la clase Convocatoria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "beca_id")
    private Beca beca;

    @NotNull
    private Integer anio;

    @NotNull
    @Column(nullable = false, name = "fecha_abierto")
    private OffsetDateTime fechaAbierto;

    @Column(nullable = false, name = "fecha_cerrado")
    private OffsetDateTime fechaCerrado;

    @Size(max = 200)
    @Column(length = 200)
    private String descripcion;
    // private estadoConvocatoria estado;

}
