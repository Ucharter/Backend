package com.sitiapp.api_backend.controller;

import com.sitiapp.api_backend.exceptions.ModelNotFond;
import com.sitiapp.api_backend.model.Usuario;
import com.sitiapp.api_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/login")
public class LogInController {

    @Autowired
    private UserService userService;

    @GetMapping("/{user}")
    public ResponseEntity<Usuario> auth(@PathVariable("user") String usuario){
        Usuario aux = userService.findByUsername(usuario);
        if (aux==null){
            throw new ModelNotFond("El USUARIO  no existe");
        }
        return new ResponseEntity<>(aux,HttpStatus.OK);
    }

}
