package com.sitiapp.api_backend.controller.Request;

import com.sitiapp.api_backend.model.Facturas;

import java.util.List;

public class PlantillaRequest {
    private Facturas factura;

    private List<InRequest> inRequest;

    public Facturas getFactura() {
        return factura;
    }

    public void setFactura(Facturas factura) {
        this.factura = factura;
    }

    public List<InRequest> getInRequest() {
        return inRequest;
    }

    public void setInRequest(List<InRequest> inRequest) {
        this.inRequest = inRequest;
    }
}
