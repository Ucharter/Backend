package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Clientes;
import com.sitiapp.api_backend.repository.IclienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IclienteService {

    @Autowired
    private IclienteRepository clienteRepository;

    @Override
    public Clientes create(Clientes cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Clientes update(Clientes cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Clientes findbyid(int id) {
        Optional<Clientes> optional;
        optional = clienteRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Clientes> findall() {
        return clienteRepository.findAll();
    }

    @Override
    public void delete(int id) {
        clienteRepository.deleteById(id);
    }
}