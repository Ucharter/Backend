package com.sitiapp.api_backend.controller.Request;

public class InRequest {
    private int idProducto;
    private int cantidad;
    private int valorUnitario;

    public InRequest() {
    }

    public InRequest(int idProducto, int cantidad, int valorUnitario) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
