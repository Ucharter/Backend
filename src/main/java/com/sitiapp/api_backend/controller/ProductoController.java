package com.sitiapp.api_backend.controller;

import com.sitiapp.api_backend.exceptions.ModelNotFond;
import com.sitiapp.api_backend.model.Productos;
import com.sitiapp.api_backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Productos>> findAll(){
        return new ResponseEntity<>(productoService.findall(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> findById(@PathVariable("id") Integer idproducto){
        Productos producto = productoService.findbyid(idproducto);
        if(producto == null){
            throw new ModelNotFond("El Usuario no fue encontrado");
        }
        return new ResponseEntity<>(producto,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Productos> create(@RequestBody Productos producto){
        return new ResponseEntity<>(productoService.create(producto),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Productos inproducto){
        Productos producto = productoService.findbyid(inproducto.getIdProducto());
        inproducto.setFacturaDetalles(producto.getFacturaDetalles());
        return new ResponseEntity<>(productoService.update(inproducto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idproducto){
        Productos producto = productoService.findbyid(idproducto);
        if(producto == null){
            throw new ModelNotFond("El Producto que desea Eliminar no existe");
        }
        productoService.delete(idproducto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
