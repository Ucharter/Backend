package com.sitiapp.api_backend.repository;

import com.sitiapp.api_backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IusuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findFirstByusuario(String usuario);

}
