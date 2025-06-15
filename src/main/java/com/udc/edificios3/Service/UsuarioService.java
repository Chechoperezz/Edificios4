package com.udc.edificios3.Service;

import com.udc.edificios3.Entities.Usuario;
import com.udc.edificios3.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario agregarUsuario(Usuario usuario) {
        Optional<Usuario> existente = usuarioRepository.findByCedula(usuario.getCedula());
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un usuario con esa cédula.");
        }
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> iniciarSesion(String cedula, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByCedula(cedula);
        if (usuario.isPresent() && usuario.get().getPassword().equals(password)) {
            return usuario;
        }
        return Optional.empty();
    }

    public Optional<Usuario> buscarPorCedula(String cedula) {
        return usuarioRepository.findByCedula(cedula);
    }

    public void cambiarPassword(Usuario usuario, String nuevaPassword) {
        if (nuevaPassword.length() < 4) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 4 caracteres.");
        }
        usuario.setPassword(nuevaPassword);
        usuarioRepository.save(usuario);
    }
}
