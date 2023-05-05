package com.sitiapp.api_backend.service;

import com.sitiapp.api_backend.model.Usuario;
import com.sitiapp.api_backend.repository.IusuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IuserService{

    @Autowired
    private IusuarioRepository usuarioRepo;

    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario findbyid(int id) {
        Optional<Usuario> obtional;
        obtional= usuarioRepo.findById(id);
        return obtional.orElse(null);
    }

    @Override
    public Usuario buscarUsuario(String usuario) {
        return null;
    }

    @Override
    public List<Usuario> findall() {
        return usuarioRepo.findAll();
    }

    @Override
    public void delete(int id){
        usuarioRepo.deleteById(id);
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepo.findFirstByusuario(username);
    }

}
