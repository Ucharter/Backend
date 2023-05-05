package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Tipos_Identificaciones;
import com.sitiapp.api_backend.repository.Itipos_identificacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Tipo_IdentificacionService implements Itipo_identificacionService {

    @Autowired
    private Itipos_identificacionesRepository dentificacionesRepository;

    @Override
    public Tipos_Identificaciones create(Tipos_Identificaciones tipos_identificacion) {
        return dentificacionesRepository.save(tipos_identificacion);
    }

    @Override
    public Tipos_Identificaciones update(Tipos_Identificaciones tipos_identificacion) {
        return dentificacionesRepository.save(tipos_identificacion);
    }

    @Override
    public Tipos_Identificaciones findbyid(int id) {
        Optional<Tipos_Identificaciones> optional;
        optional = dentificacionesRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Tipos_Identificaciones> findall() {
        return dentificacionesRepository.findAll();
    }

    @Override
    public void delete(int id) {
        dentificacionesRepository.deleteById(id);
    }
}
