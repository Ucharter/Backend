package com.sitiapp.api_backend.repository;

import com.sitiapp.api_backend.model.Factura_Detalle;
import com.sitiapp.api_backend.model.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ifactura_detalleRepository extends JpaRepository<Factura_Detalle,Integer> {
    void deleteAllByconsecutivo(Facturas factura);
}
