package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Perfil;

import java.util.List;

public interface IperfilService {
    Perfil create(Perfil usuario);

    Perfil update(Perfil usuario);

    Perfil findbyid(int id);

    List<Perfil> findall();

    void delete(int id);
}
