package com.miempresa.miloginweb.service;

import com.miempresa.miloginweb.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private final List<Usuario> listaUsuarios = new ArrayList<>();
    private long nextId = 3; 

    public UsuarioService() {
        // Datos de ejemplo iniciales
        listaUsuarios.add(new Usuario(1L, "Juan Pérez", "juan@mail.com", "Empleado", "juan", "1234"));
        listaUsuarios.add(new Usuario(2L, "Ana López", "ana@mail.com", "Cliente", "ana", "1234"));
    }

    public List<Usuario> findAll() {
        return listaUsuarios;
    }

    // Función para AGREGAR un nuevo usuario
    public void save(Usuario usuario) {
        usuario.setId(nextId++);
        listaUsuarios.add(usuario);
    }
    
    // Función para BUSCAR un usuario por ID (Necesaria para Editar)
    public Usuario findById(Long id) {
        return listaUsuarios.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Función para ACTUALIZAR un usuario
    public void update(Usuario usuarioActualizado) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId().equals(usuarioActualizado.getId())) {
                listaUsuarios.set(i, usuarioActualizado);
                return;
            }
        }
    }
    
    // Función para ELIMINAR un usuario
    public void deleteById(Long id) {
        listaUsuarios.removeIf(user -> user.getId().equals(id));
    }
}