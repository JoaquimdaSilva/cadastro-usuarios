package com.joaquimventura.cadastrousuarios.controller;

import com.joaquimventura.cadastrousuarios.model.Usuario;
import com.joaquimventura.cadastrousuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

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
        if(u.getId() != null && u.getId() > 0){
            Usuario old = repository.findById(u.getId()).orElse(null);
            old.setNome(u.getNome());
            old.setDataNascimento(u.getDataNascimento());
            old.setAvatar(u.getAvatar());
            return repository.save(old);
        }else{
            return repository.save(u);
        }

    }


    @GetMapping
    public Usuario porId(@PathVariable Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}


