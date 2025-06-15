package com.udc.edificios3.Repository;

import com.udc.edificios3.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCedulaAndPassword(String cedula, String password);
    Optional<Usuario> findByCedula(String cedula);
}
