package com.sitiapp.api_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FACTURAS")
public class Facturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSECUTIVO")
    private Integer consecutivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "CLIENTE")
    private Clientes cliente;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA")
    private Date fecha;

    @OneToMany(mappedBy = "consecutivo", cascade = CascadeType.ALL,orphanRemoval = true , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Factura_Detalle> facturaDetalles;

    public Facturas() {}

    public Facturas(Clientes cliente, Date fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Factura_Detalle> getFacturaDetalles() {
        return facturaDetalles;
    }

    public void setFacturaDetalles(List<Factura_Detalle> facturaDetalles) {
        this.facturaDetalles = facturaDetalles;
    }
}
