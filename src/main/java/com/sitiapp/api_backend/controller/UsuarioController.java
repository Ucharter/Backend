package com.sitiapp.api_backend.controller;

import com.sitiapp.api_backend.exceptions.ModelNotFond;
import com.sitiapp.api_backend.model.Perfil;
import com.sitiapp.api_backend.model.Usuario;
import com.sitiapp.api_backend.service.PerfilService;
import com.sitiapp.api_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UserService userService;

    @Autowired
    private PerfilService perfilService;


    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return new ResponseEntity<>(userService.findall(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario,@PathVariable Integer id){
        Perfil perfil = perfilService.findbyid(id);
        usuario.setPerfil(perfil);
        perfil.getUsuarios().add(usuario);
        return new ResponseEntity<>(userService.create(usuario),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Usuario inusuario){
         Usuario usuario = userService.findbyid(inusuario.getId_usuario());
         inusuario.setPerfil(usuario.getPerfil());
         Perfil perfil = usuario.getPerfil();
         perfil.getUsuarios().remove(usuario);
         perfil.getUsuarios().add(inusuario);
         return new ResponseEntity<>(userService.update(inusuario),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable("id") Integer idusuario){
        Usuario usuario = userService.findbyid(idusuario);
        if(usuario == null){
            throw new ModelNotFond("El Usuario no fue encontrado");
        }
        return new ResponseEntity<>(usuario,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idusuario){
        Usuario usuario = userService.findbyid(idusuario);
        if(usuario == null){
            throw new ModelNotFond("El Usuario que desea Eliminar no existe");
        }
        Perfil perfil = usuario.getPerfil();
        perfil.getUsuarios().remove(usuario);
        userService.delete(idusuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
