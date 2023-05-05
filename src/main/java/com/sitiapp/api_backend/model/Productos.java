package com.sitiapp.api_backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCTOS")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;

    @Column(name = "NOMBRE", nullable = true, length = 100)
    private String nombre;

    @Column(name = "ESTADO", nullable = true, length = 45)
    private String estado;

    @Column(name = "VALOR_UNITARIO", nullable = true)
    private Integer valorUnitario;

    @OneToMany(mappedBy = "idProducto", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Factura_Detalle> facturaDetalles;

    public Productos() {}

    public Productos(String nombre, String estado, Integer valorUnitario) {
        this.nombre = nombre;
        this.estado = estado;
        this.valorUnitario = valorUnitario;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Integer valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public List<Factura_Detalle> getFacturaDetalles() {
        return facturaDetalles;
    }

    public void setFacturaDetalles(List<Factura_Detalle> facturaDetalles) {
        this.facturaDetalles = facturaDetalles;
    }
}
