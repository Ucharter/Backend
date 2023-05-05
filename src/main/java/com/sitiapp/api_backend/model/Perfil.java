package com.sitiapp.api_backend.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Integer id_perfil;

    @Column(name = "nombre", nullable = false, length = 13)
    private String nombre;

    @OneToMany(mappedBy = "perfil", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Usuario> usuarios;

    public Perfil() {
    }

    public Perfil(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Integer id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
