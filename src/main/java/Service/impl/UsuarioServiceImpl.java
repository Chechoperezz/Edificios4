package Service.impl;

import Entities.Usuario;
import Repository.UsuarioRepository;
import Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {

        if (usuarioRepository.existsById(usuario.getId())) {
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Override
    public Usuario iniciarSesion(String cedula, String password) {
        return usuarioRepository.findByCedulaAndPassword(cedula, password);
    }

    @Override
    public Usuario recuperarContrasena(String cedula, String respuestaSeguridad) {
        return usuarioRepository.findByCedulaAndRespuestaSeguridad(cedula, respuestaSeguridad);
    }

    @Override
    public Usuario cambiarContrasena(Long id, String nuevaContrasena) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setPassword(nuevaContrasena);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Override
    public Usuario findByCedula(String cedula) {
        return usuarioRepository.findByCedula(cedula);
    }
}
