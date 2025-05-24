package com.exeptions.examples.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/operaciones")
public class Operaciones {

    @GetMapping("/divide")
    public String Divide() {
        int valor = 20 / 0;
        return "El resultado de la división es: " + valor;
    }
    
}
