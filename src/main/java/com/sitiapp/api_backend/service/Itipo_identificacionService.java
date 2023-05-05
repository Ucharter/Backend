package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Tipos_Identificaciones;

import java.util.List;

public interface Itipo_identificacionService {
    Tipos_Identificaciones create(Tipos_Identificaciones usuario);

    Tipos_Identificaciones update(Tipos_Identificaciones usuario);

    Tipos_Identificaciones findbyid(int id);

    List<Tipos_Identificaciones> findall();

    void delete(int id);
}
