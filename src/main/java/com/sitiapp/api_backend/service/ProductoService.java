package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Productos;
import com.sitiapp.api_backend.repository.IproductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IproductoService{

    @Autowired
    private IproductoRepository productosRepository;

    @Override
    public Productos create(Productos producto) {
        return productosRepository.save(producto);
    }

    @Override
    public Productos update(Productos producto) {
        return productosRepository.save(producto);
    }

    @Override
    public Productos findbyid(int id) {
        Optional<Productos> optional;
        optional = productosRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Productos> findall() {
        return productosRepository.findAll();
    }

    @Override
    public void delete(int id) {
        productosRepository.deleteById(id);
    }
}
