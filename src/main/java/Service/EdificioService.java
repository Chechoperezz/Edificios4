package Service;

import Entities.Edificio;

import java.util.List;
import java.util.Optional;

public interface EdificioService {
    Edificio guardarEdificio(Edificio edificio);
    Optional<Edificio> obtenerEdificioPorId(Long id);
    List<Edificio> obtenerTodosLosEdificios();
    void eliminarEdificio(Long id);
    Edificio actualizarEdificio(Edificio edificio);
    Edificio buscarPorNombre(String nombre);
}
