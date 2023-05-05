package com.sitiapp.api_backend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CLIENTES")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENTE")
    private Integer cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "TIPO_IDENTIFICACION")
    private Tipos_Identificaciones tipo;

    @Column(name = "IDENTIFICACION", nullable = true, length = 100)
    private String identificacion;

    @Column(name = "RAZON_SOCIAL", nullable = true, length = 100)
    private String razonSocial;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;

    @Column(name = "ESTADO", nullable = true, length = 1)
    private String estado;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Facturas> facturas;

    public Clientes() {}

    public Clientes(Tipos_Identificaciones tipo, String identificacion, String razonSocial, Date fechaRegistro, String estado) {
        this.tipo = tipo;
        this.identificacion = identificacion;
        this.razonSocial = razonSocial;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Tipos_Identificaciones getTipo() {
        return tipo;
    }

    public void setTipo(Tipos_Identificaciones tipo) {
        this.tipo = tipo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Facturas> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Facturas> facturas) {
        this.facturas = facturas;
    }
}
