package Service;

import Entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario guardarUsuario(Usuario usuario);
    Optional<Usuario> obtenerUsuarioPorId(Long id);
    List<Usuario> obtenerTodosLosUsuarios();
    void eliminarUsuario(Long id);
    Usuario actualizarUsuario(Usuario usuario);
    Usuario iniciarSesion(String cedula, String password);
    Usuario recuperarContrasena(String cedula, String respuestaSeguridad);
    Usuario cambiarContrasena(Long id, String nuevaContrasena);

    Usuario findByCedula(String cedula);
}
