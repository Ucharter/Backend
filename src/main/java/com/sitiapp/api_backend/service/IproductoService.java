package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Productos;

import java.util.List;

public interface IproductoService {
    Productos create(Productos usuario);

    Productos update(Productos usuario);

    Productos findbyid(int id);

    List<Productos> findall();

    void delete(int id);
}
