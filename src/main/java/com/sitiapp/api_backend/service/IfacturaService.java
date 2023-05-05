package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Facturas;

import java.util.List;

public interface IfacturaService {
    Facturas create(Facturas usuario);

    Facturas update(Facturas usuario);

    Facturas findbyid(int id);

    List<Facturas> findall();

    void delete(int id);
}
