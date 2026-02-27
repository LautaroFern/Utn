package com.Becas.Utn.Model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {
// Creacion de atributos de la clase Usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false)
    private String nombre;

    @NotNull
    @Size(max = 100)
    @Column (nullable = false)
    private String apellido;

    @NotNull

    @Size(max = 100)
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotNull
    @Size(max = 255)
    @Column (nullable = false, length = 255)
    private String  password;

    @Column (name = "estado", nullable = false)
    private boolean estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    

    public Usuario(){
        this.nombre= "";
        this.apellido= "";
        this.email= "";
        this.password= "";
        this.estado= true;
    }

    public Usuario(String nombre, String apellido, String email, String password){
        this.nombre= nombre;
        this.apellido= apellido;
        this.email= email;
        this.password= password;
        this.estado= true;
    }

    // Getters Y Setters de la clase Usuario
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

        public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    // Metodos Equals , HashCode y ToString
    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id != null && id.equals(usuario.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Usuario: " + 
        "Id: " + this.id +
        "Nombre: " + this.nombre + 
        "Apellido: " + this.apellido +
        "Email: " + this.email;
    }
}

