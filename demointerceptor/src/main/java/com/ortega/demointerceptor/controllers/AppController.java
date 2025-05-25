package com.ortega.demointerceptor.controllers;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AppController {

  @GetMapping("/indice")

  public ResponseEntity<?> get(HttpServletRequest req){
    Map<String, Object> datos = new HashMap<>();
    datos.put("titulo", "Sistema de control de acceso");
    datos.put("hora", new Date());
    datos.put("Mensaje", req.getAttribute("Mensaje"));
    return ResponseEntity.ok(datos);
  }
}
