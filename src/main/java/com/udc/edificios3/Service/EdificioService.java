package com.udc.edificios3.Service;

import com.udc.edificios3.Entities.Edificio;
import com.udc.edificios3.Repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public Edificio agregarEdificio(Edificio edificio) {
        if (edificio.getNombre() == null || edificio.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        return edificioRepository.save(edificio);
    }

    public Optional<Edificio> buscarPorId(Long id) {
        return edificioRepository.findById(id);
    }

    public Edificio editarEdificio(Edificio edificio) {
        if (!edificioRepository.existsById(edificio.getId())) {
            throw new IllegalArgumentException("El edificio no existe");
        }
        return edificioRepository.save(edificio);
    }

    public void eliminarEdificio(Long id) {
        if (edificioRepository.existsById(id)) {
            edificioRepository.deleteById(id);
        }
    }

    public List<Edificio> listarTodos() {
        return edificioRepository.findAll();
    }
}
