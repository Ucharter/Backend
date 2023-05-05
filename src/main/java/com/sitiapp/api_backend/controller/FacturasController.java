package com.sitiapp.api_backend.controller;

import com.sitiapp.api_backend.controller.Request.InRequest;
import com.sitiapp.api_backend.controller.Request.PlantillaRequest;
import com.sitiapp.api_backend.exceptions.ModelNotFond;
import com.sitiapp.api_backend.model.*;
import com.sitiapp.api_backend.service.ClienteService;
import com.sitiapp.api_backend.service.FacturaService;
import com.sitiapp.api_backend.service.Factura_DetalleService;
import com.sitiapp.api_backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/facturas")
public class FacturasController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private Factura_DetalleService facturaDetalleService;

    @GetMapping
    public ResponseEntity<List<Facturas>> findAll(){
        return new ResponseEntity<>(facturaService.findall(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facturas> findById(@PathVariable("id") Integer idfactura){
        Facturas factura = facturaService.findbyid(idfactura);
        if(factura == null){
            throw new ModelNotFond("El factura no fue encontrado");
        }
        return new ResponseEntity<>(factura,HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Facturas> create(@RequestBody PlantillaRequest peticion, @PathVariable Integer id) {
        Clientes cliente = clienteService.findbyid(id);int x=0;
        Facturas factura = peticion.getFactura();
        factura.setCliente(cliente);
        Factura_Detalle facturaDetalle = null;
        if(factura.getFacturaDetalles() == null){factura.setFacturaDetalles(new ArrayList<>());}
        for (InRequest aux : peticion.getInRequest()) {
            Productos producto = productoService.findbyid(aux.getIdProducto());
            facturaDetalle = new Factura_Detalle(aux.getCantidad(), aux.getValorUnitario());
            facturaDetalle.setIdProducto(producto);
            facturaDetalle.setConsecutivo(factura);
            factura.getFacturaDetalles().add(facturaDetalle);
            if(producto.getFacturaDetalles() == null){producto.setFacturaDetalles(new ArrayList<>());}
            producto.getFacturaDetalles().add(facturaDetalle);
            if(x==0){
                x++;
                cliente.getFacturas().add(factura);
                facturaService.create(factura);
            }
            facturaDetalleService.create(facturaDetalle);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idfactura){
        Facturas factura = facturaService.findbyid(idfactura);
        if(factura == null){
            throw new ModelNotFond("La factura que desea Eliminar no existe");
        }
        factura.getFacturaDetalles().removeAll(factura.getFacturaDetalles());
        facturaService.delete(idfactura);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
