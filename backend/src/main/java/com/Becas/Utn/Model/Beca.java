package com.Becas.Utn.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "beca")
public class Beca {
    //Creacion de los atributos de la clase beca
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(max = 150)
    @Column(nullable = false, length = 150)
    private String nombre;

    @NotNull
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @NotNull
    @Size(max = 30)
    @Column(name = "tipo_beca", nullable = false, length = 30)
    private String tipoBeca; 

    @Column(name = "requiere_ingenieria", nullable = false)
    private boolean requiereIngenieria;

    //CREAR RELACION  BIDIRECCIONAL CON CONVOCATORIA¿? 
    //Modificar BDD EN CASO DE SER ASI (y crear mas uniones bidireccionales)
    /*
        @OneToMany(mappedBy = "beca", cascade = CascadeType.All)
        private List<Convocatoria> convocatorias = new ArrayList<>();
    */

    //Constructores
    public Beca () {

    }

    public Beca(String nombre, String descripcion, String tipoBeca, boolean requiereIngenieria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoBeca = tipoBeca;
        this.requiereIngenieria = requiereIngenieria;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoBeca() {
        return tipoBeca;
    }
    public void setTipoBeca(String tipoBeca) {
        this.tipoBeca = tipoBeca;
    }
    public boolean isRequiereIngenieria() {
        return requiereIngenieria;
    }
    public void setRequiereIngenieria(boolean requiereIngenieria) {
        this.requiereIngenieria = requiereIngenieria;
    }

    //Equal y Hashcode de la clase Beca
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Beca)) return false;
        Beca beca = (Beca) o;
        return id != null && id.equals(beca.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
}
