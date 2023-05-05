package com.sitiapp.api_backend.repository;

import com.sitiapp.api_backend.model.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IfacturasRepository extends JpaRepository<Facturas,Integer> {
}
