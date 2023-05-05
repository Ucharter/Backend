package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Perfil;
import com.sitiapp.api_backend.repository.IperfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService implements IperfilService{

    @Autowired
    private IperfilRepository perfilRepository;

    @Override
    public Perfil create(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public Perfil update(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public Perfil findbyid(int id) {
        Optional<Perfil> optional;
        optional = perfilRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Perfil> findall() {
        return perfilRepository.findAll();
    }

    @Override
    public void delete(int id) {
        perfilRepository.deleteById(id);
    }
}
