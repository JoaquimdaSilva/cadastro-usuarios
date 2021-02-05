package com.joaquimventura.cadastrousuarios.controller;

import com.joaquimventura.cadastrousuarios.model.Usuario;
import com.joaquimventura.cadastrousuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/listar")
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarOuAtualizar(@RequestBody Usuario u) {
        return repository.save(u);
    }


    @GetMapping
    public Usuario porId(@PathVariable Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}


