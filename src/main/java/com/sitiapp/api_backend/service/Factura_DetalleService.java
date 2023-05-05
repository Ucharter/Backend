package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Factura_Detalle;
import com.sitiapp.api_backend.model.Facturas;
import com.sitiapp.api_backend.model.Productos;
import com.sitiapp.api_backend.repository.Ifactura_detalleRepository;
import com.sitiapp.api_backend.repository.IproductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Factura_DetalleService implements Ifactura_detalleService{

    @Autowired
    private Ifactura_detalleRepository factura_detalleRepository;

    @Autowired
    private ProductoService productoService;

    @Override
    public Factura_Detalle create(Factura_Detalle factura_detalle) {
        return factura_detalleRepository.save(factura_detalle);
    }

    @Override
    public Factura_Detalle update(Factura_Detalle factura_detalle) {
        return factura_detalleRepository.save(factura_detalle);
    }

    @Override
    public Factura_Detalle findbyid(int id) {
        Optional<Factura_Detalle> optional;
        optional = factura_detalleRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Factura_Detalle> findall() {
        return factura_detalleRepository.findAll();
    }

    @Override
    public void delete(int id) {
        factura_detalleRepository.deleteById(id);
    }

    @Override
    public void deleteAllByconsecutivo(Facturas factura) {
        factura_detalleRepository.deleteAllByconsecutivo(factura);
    }
}
