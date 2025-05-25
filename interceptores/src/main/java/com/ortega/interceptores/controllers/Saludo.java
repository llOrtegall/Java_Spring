package com.ortega.interceptores.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping
public class Saludo {
  @GetMapping("/saludo")
  public String Greetings() throws InterruptedException {
    Thread.sleep(5000);
    return "Saludo a todos desde el controlador Saludo";
  }

}
