package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Clientes;

import java.util.List;

public interface IclienteService {
    Clientes create(Clientes usuario);

    Clientes update(Clientes usuario);

    Clientes findbyid(int id);

    List<Clientes> findall();

    void delete(int id);
}
