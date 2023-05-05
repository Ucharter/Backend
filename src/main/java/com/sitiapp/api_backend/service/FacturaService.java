package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Facturas;
import com.sitiapp.api_backend.repository.IfacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService implements IfacturaService{

    @Autowired
    private IfacturasRepository facturasRepository;

    @Override
    public Facturas create(Facturas factura) {
        return facturasRepository.save(factura);
    }

    @Override
    public Facturas update(Facturas factura) {
        return facturasRepository.save(factura);
    }

    @Override
    public Facturas findbyid(int id) {
        Optional<Facturas> optional;
        optional = facturasRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Facturas> findall() {
        return facturasRepository.findAll();
    }

    @Override
    public void delete(int id) {
        facturasRepository.deleteById(id);
    }
}
