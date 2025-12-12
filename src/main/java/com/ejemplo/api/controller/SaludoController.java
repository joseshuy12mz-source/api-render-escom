package com.ejemplo.api.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SaludoController {
    
    @GetMapping("/")
    public Map<String, String> inicio() {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "API funcionando correctamente");
        response.put("version", "1.0.0");
        response.put("autor", "Jose Shuy");
        return response;
    }
    
    @GetMapping("/saludo")
    public Map<String, String> saludo() {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "¡Hola Mundo desde Spring Boot!");
        return response;
    }
    
    @GetMapping("/saludo/{nombre}")
    public Map<String, String> saludoPersonalizado(@PathVariable String nombre) {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "¡Hola " + nombre + "!");
        response.put("hora", java.time.LocalDateTime.now().toString());
        return response;
    }
    
    @GetMapping("/info")
    public Map<String, Object> info() {
        Map<String, Object> response = new HashMap<>();
        response.put("aplicacion", "API Render - IPN ESCOM");
        response.put("descripcion", "API desplegada en Render.com");
        response.put("endpoints", new String[]{
            "/api/",
            "/api/saludo",
            "/api/saludo/{nombre}",
            "/api/info"
        });
        return response;
    }
}
