package com.miempresa.miloginweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*; // Usa todas las anotaciones web

import com.miempresa.miloginweb.model.Usuario;
import com.miempresa.miloginweb.service.UsuarioService;

@Controller
public class SistemaController {

    @Autowired
    private UsuarioService usuarioService; 

    // 1. Muestra la tabla de gestión de usuarios (GET /usuario)
    @GetMapping("/usuario") 
    public String panelUsuarios(Model model) {
        model.addAttribute("listaUsuarios", usuarioService.findAll());
        model.addAttribute("nuevoUsuario", new Usuario()); 
        return "usuario_panel"; // Carga la plantilla con la tabla
    }
    
    // 2. Procesa la acción de AGREGAR (POST /usuario/agregar)
    @PostMapping("/usuario/agregar") 
    public String agregarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuario"; 
    }

    // 3. Muestra el formulario con datos precargados (GET /usuario/editar/{id})
    @GetMapping("/usuario/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        
        Usuario usuarioAEditar = usuarioService.findById(id); 
        model.addAttribute("usuarioAEditar", usuarioAEditar);
        
        return "usuario_editar"; // Carga la plantilla de edición
    }

    // 4. Guarda los cambios editados (POST /usuario/guardarCambios)
    @PostMapping("/usuario/guardarCambios")
    public String guardarCambios(@ModelAttribute Usuario usuario) {
        usuarioService.update(usuario); 
        return "redirect:/usuario";
    }
    
    // 5. Elimina el usuario (GET /usuario/eliminar/{id})
    @GetMapping("/usuario/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id); 
        return "redirect:/usuario"; 
    }
    
    // 6. Navegación (Debes tener aquí los métodos para /sistema, /compras, /cupon)
    @GetMapping("/sistema") public String mostrarPanelInicio() { return "inicio"; }
    @GetMapping("/compras") public String mostrarPanelCompras() { return "compras_panel"; }
    @GetMapping("/cupon") public String mostrarPanelCupon(Model model) { return "cupon_panel"; }
}