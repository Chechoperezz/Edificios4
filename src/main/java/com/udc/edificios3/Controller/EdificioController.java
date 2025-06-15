package com.udc.edificios3.Controller;

import com.udc.edificios3.Entities.Edificio;
import com.udc.edificios3.Repository.EdificioRepository;
import com.udc.edificios3.Service.EdificioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/edificio")
public class EdificioController {

    @Autowired
    private EdificioService edificioService;


    @GetMapping("/index")
    public String index() {
        return "edificio/index";
    }


    @GetMapping("/agregar")
    public String formularioAgregar() {
        return "edificio/agregar";
    }


    @PostMapping("/agregar")
    public String agregarEdificio(@ModelAttribute Edificio edificio) {
        edificioService.agregarEdificio(edificio);
        return "redirect:/edificio/listar";
    }


    @GetMapping("/buscar")
    public String formularioBuscar() {
        return "edificio/buscar";
    }

    @PostMapping("/buscar")
    public String buscarEdificio(@RequestParam Long id, HttpSession session, Model model) {
        Optional<Edificio> edificioOpt = edificioService.buscarPorId(id);
        if (edificioOpt.isPresent()) {
            session.setAttribute("edificioBuscado", edificioOpt.get());
            model.addAttribute("edificio", edificioOpt.get());
        } else {
            model.addAttribute("error", "Edificio no encontrado");
        }
        return "edificio/buscar";
    }


    @GetMapping("/editar")
    public String formularioEditar(HttpSession session, Model model) {
        Edificio edificio = (Edificio) session.getAttribute("edificioBuscado");
        model.addAttribute("edificio", edificio);
        return "edificio/editar";
    }

    @PostMapping("/editar")
    public String editarEdificio(@ModelAttribute Edificio edificio, HttpSession session) {
        edificioService.editarEdificio(edificio);
        session.setAttribute("edificioBuscado", edificio);
        return "redirect:/edificio/listar";
    }


    @GetMapping("/eliminar")
    public String eliminarEdificio(HttpSession session) {
        Edificio edificio = (Edificio) session.getAttribute("edificioBuscado");
        edificioService.eliminarEdificio(edificio.getId());
        session.removeAttribute("edificioBuscado");
        return "redirect:/edificio/listar";
    }


    @GetMapping("/listar")
    public String listarEdificios(Model model) {
        List<Edificio> lista = edificioService.listarTodos();
        model.addAttribute("listaEdificios", lista);
        return "edificio/listar";
    }
}