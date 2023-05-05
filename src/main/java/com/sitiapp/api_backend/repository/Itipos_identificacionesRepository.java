package com.sitiapp.api_backend.repository;

import com.sitiapp.api_backend.model.Tipos_Identificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Itipos_identificacionesRepository extends JpaRepository<Tipos_Identificaciones,Integer> {
}
