// Archivo LoginController.java

// 🚨 ¡ESTA LÍNEA ES OBLIGATORIA! 🚨
package com.miempresa.miloginweb.controller; 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody; 
import org.springframework.stereotype.Controller; 
import com.miempresa.miloginweb.model.Usuario; 

@Controller 
public class LoginController {

    // Devuelve el formulario de login.html
    @GetMapping("/")
    public String paginaPrincipal() {
        return "login"; 
    }

    // Procesa el login y redirige a /sistema
    @PostMapping("/auth/login")
    public String procesarLogin(@ModelAttribute Usuario usuario) {
        
        String usuarioIngresado = usuario.getUsername();
        String claveIngresada = usuario.getPassword();
        
        if ("admin".equals(usuarioIngresado) && "1234".equals(claveIngresada)) {
            return "redirect:/sistema"; 
        } else {
            return "redirect:/"; 
        }
    }
}