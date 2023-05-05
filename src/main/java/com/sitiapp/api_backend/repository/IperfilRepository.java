package com.sitiapp.api_backend.repository;

import com.sitiapp.api_backend.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IperfilRepository extends JpaRepository<Perfil,Integer> {
}
