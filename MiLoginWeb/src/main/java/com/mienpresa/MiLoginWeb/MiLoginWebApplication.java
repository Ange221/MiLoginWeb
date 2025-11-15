package com.miempresa.miloginweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Esta es la clase que Gradle ejecuta para arrancar la aplicación
@SpringBootApplication
public class MiLoginWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiLoginWebApplication.class, args);
    }
}