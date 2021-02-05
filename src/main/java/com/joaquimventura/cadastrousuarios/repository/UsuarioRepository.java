package com.joaquimventura.cadastrousuarios.repository;

import com.joaquimventura.cadastrousuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}