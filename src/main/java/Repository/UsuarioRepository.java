package Repository;

import Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByCedula(String cedula);
    Usuario findByCedulaAndPassword(String cedula, String password);
    Usuario findByCedulaAndRespuestaSeguridad(String cedula, String respuestaSeguridad);
}
