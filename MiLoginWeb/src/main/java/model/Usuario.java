package com.miempresa.miloginweb.model;

public class Usuario {
    private Long id;
    private String nombre;
    private String correo;
    private String rol;    
    private String username; 
    private String password; 

    public Usuario() {}

    // 🚨 CONSTRUCTOR COMPLETO (NECESARIO PARA EL SERVICE) 🚨
    public Usuario(Long id, String nombre, String correo, String rol, String username, String password) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.username = username;
        this.password = password;
    }
    
    // Constructor para el formulario (sin ID, lo genera el servicio)
    public Usuario(String nombre, String correo, String rol, String username, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.username = username;
        this.password = password;
    }

    // --- Getters y Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}