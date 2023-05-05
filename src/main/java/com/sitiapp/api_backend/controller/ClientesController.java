package com.sitiapp.api_backend.controller;

import com.sitiapp.api_backend.exceptions.ModelNotFond;
import com.sitiapp.api_backend.model.Clientes;
import com.sitiapp.api_backend.model.Perfil;
import com.sitiapp.api_backend.model.Tipos_Identificaciones;
import com.sitiapp.api_backend.model.Usuario;
import com.sitiapp.api_backend.service.ClienteService;
import com.sitiapp.api_backend.service.Tipo_IdentificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private Tipo_IdentificacionService tipoIdentificacionService;

    @GetMapping
    public ResponseEntity<List<Clientes>> findAll(){
        return new ResponseEntity<>(clienteService.findall(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> findById(@PathVariable("id") Integer idcliente){
        Clientes cliente = clienteService.findbyid(idcliente);
        if(cliente == null){
            throw new ModelNotFond("El cliente no fue encontrado");
        }
        return new ResponseEntity<>(cliente,HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Clientes> create(@RequestBody Clientes cliente, @PathVariable Integer id){
        Tipos_Identificaciones tipo = tipoIdentificacionService.findbyid(id);
        cliente.setTipo(tipo);
        tipo.getClientes().add(cliente);
        return new ResponseEntity<>(clienteService.create(cliente),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Clientes incliente){
        Clientes cliente = clienteService.findbyid(incliente.getCliente());
        incliente.setTipo(cliente.getTipo());
        Tipos_Identificaciones tipo = cliente.getTipo();
        tipo.getClientes().remove(cliente);
        tipo.getClientes().add(incliente);
        incliente.setFacturas(cliente.getFacturas());
        return new ResponseEntity<>(clienteService.update(incliente),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idcliente){
        Clientes cliente = clienteService.findbyid(idcliente);
        if(cliente == null){
            throw new ModelNotFond("El Cliente que desea Eliminar no existe");
        }
        Tipos_Identificaciones tipo = cliente.getTipo();
        tipo.getClientes().remove(cliente);
        clienteService.delete(idcliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
