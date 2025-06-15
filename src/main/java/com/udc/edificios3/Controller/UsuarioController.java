package com.udc.edificios3.Controller;


import com.udc.edificios3.Entities.Usuario;
import com.udc.edificios3.Service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/login")
    public String loginForm() {
        return "usuario/login";
    }


    @PostMapping("/iniciar_sesion")
    public String iniciarSesion(@RequestParam String cedula, @RequestParam String password, HttpSession session, Model model) {
        Optional<Usuario> usuarioOpt = usuarioService.iniciarSesion(cedula, password);
        if (usuarioOpt.isPresent()) {
            session.setAttribute("usuarioLogueado", usuarioOpt.get());
            return "redirect:/usuario/index";
        } else {
            model.addAttribute("error", "Credenciales inválidas");
            return "usuario/login";
        }
    }


    @GetMapping("/cerrar_sesion")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/usuario/login";
    }


    @GetMapping("/index")
    public String index() {
        return "usuario/index";
    }


    @GetMapping("/agregar")
    public String formularioRegistro() {
        return "usuario/agregar";
    }


    @PostMapping("/agregar")
    public String agregarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.agregarUsuario(usuario);
        return "redirect:/usuario/login";
    }


    @GetMapping("/recoverypass")
    public String formularioRecovery() {
        return "usuario/recoverypass";
    }


    @PostMapping("/recordar_pass")
    public String recordarPass(@RequestParam String cedula, @RequestParam String respuestaSeguridad, Model model) {
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorCedula(cedula);
        if (usuarioOpt.isPresent() && usuarioOpt.get().getRespuestaSeguridad().equalsIgnoreCase(respuestaSeguridad)) {
            model.addAttribute("clave", usuarioOpt.get().getPassword());
        } else {
            model.addAttribute("error", "Datos inválidos.");
        }
        return "usuario/recoverypass";
    }

    // Cambiar contraseña (usuario logueado)
    @PostMapping("/cambiar_pass")
    public String cambiarPass(@RequestParam String nuevaPassword, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        usuarioService.cambiarPassword(usuario, nuevaPassword);
        session.setAttribute("usuarioLogueado", usuario);
        return "redirect:/usuario/index";
    }
}
