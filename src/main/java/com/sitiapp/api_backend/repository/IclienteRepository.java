package com.sitiapp.api_backend.repository;

import com.sitiapp.api_backend.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IclienteRepository extends JpaRepository<Clientes,Integer> {
}
