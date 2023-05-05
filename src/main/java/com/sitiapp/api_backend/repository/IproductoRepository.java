package com.sitiapp.api_backend.repository;

import com.sitiapp.api_backend.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IproductoRepository extends JpaRepository<Productos,Integer> {
}
