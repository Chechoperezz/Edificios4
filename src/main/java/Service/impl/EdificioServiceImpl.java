package Service.impl;

import Entities.Edificio;
import Repository.EdificioRepository;
import Service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EdificioServiceImpl implements EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    @Override
    public Edificio guardarEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    @Override
    public Optional<Edificio> obtenerEdificioPorId(Long id) {
        return edificioRepository.findById(id);
    }

    @Override
    public List<Edificio> obtenerTodosLosEdificios() {
        return edificioRepository.findAll();
    }

    @Override
    public void eliminarEdificio(Long id) {
        edificioRepository.deleteById(id);
    }

    @Override
    public Edificio actualizarEdificio(Edificio edificio) {
        if (edificioRepository.existsById(edificio.getId())) {
            return edificioRepository.save(edificio);
        }
        return null;
    }

    @Override
    public Edificio buscarPorNombre(String nombre) {
        return edificioRepository.findByNombre(nombre);
    }
}
