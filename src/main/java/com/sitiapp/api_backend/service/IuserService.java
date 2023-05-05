package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Usuario;

import java.util.List;

public interface IuserService {
    Usuario create(Usuario usuario);

    Usuario update(Usuario usuario);

    Usuario findbyid(int id);

    Usuario buscarUsuario(String usuario);

    List<Usuario> findall();

    void delete(int id);

    Usuario findByUsername(String username);

}
