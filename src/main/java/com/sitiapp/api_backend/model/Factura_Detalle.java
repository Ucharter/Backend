package com.sitiapp.api_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "factura_detalle")
public class Factura_Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "CONSECUTIVO")
    private Facturas consecutivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "ID_PRODUCTO")
    private Productos idProducto;

    @Column(name = "CANTIDAD", nullable = true)
    private Integer cantidad;

    @Column(name = "VALOR_UNITARIO", nullable = true)
    private Integer valorUnitario;

    public Factura_Detalle() {}

    public Factura_Detalle(Integer cantidad, Integer valorUnitario) {
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Facturas getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Facturas consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Integer valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}