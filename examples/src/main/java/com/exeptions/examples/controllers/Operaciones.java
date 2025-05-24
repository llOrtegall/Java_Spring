package com.exeptions.examples.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/operaciones")
public class Operaciones {

  @GetMapping("/divide")
  public String Divide(
      @RequestParam(name = "numerador") String numeradorSrt,
      @RequestParam(name = "denominador") String denominadorStr) {


    try {
      int numerador = Integer.parseInt(numeradorSrt);
      int denominador = Integer.parseInt(denominadorStr);
      
      int resultado = numerador / denominador;

      return String.format("El resultado de la división es: %d", resultado);
    } catch (ArithmeticException e) {
      throw e;
    } catch (NumberFormatException e) {
      throw e;
    }

  }
}
