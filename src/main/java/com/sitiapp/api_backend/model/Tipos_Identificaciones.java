package com.sitiapp.api_backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TIPOS_IDENTIFICACIONES")
public class Tipos_Identificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIPO_IDENTIFICACION")
    private Integer tipoIdentificacion;

    @Column(name = "ABREVIATURA", nullable = true, length = 3)
    private String abreviatura;

    @Column(name = "DESCRIPCION", nullable = true, length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "tipo", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Clientes> clientes;

    public Tipos_Identificaciones() {}

    public Tipos_Identificaciones(String abreviatura, String descripcion) {
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
    }

    public Integer getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Integer tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }
}
