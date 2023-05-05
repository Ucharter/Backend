package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Factura_Detalle;
import com.sitiapp.api_backend.model.Facturas;

import java.util.List;

public interface Ifactura_detalleService {
    Factura_Detalle create(Factura_Detalle usuario);

    Factura_Detalle update(Factura_Detalle usuario);

    Factura_Detalle findbyid(int id);

    List<Factura_Detalle> findall();

    void delete(int id);

    void deleteAllByconsecutivo(Facturas factura);
}
