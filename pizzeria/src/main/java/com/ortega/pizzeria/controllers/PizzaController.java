package com.ortega.pizzeria.controller;

import com.ortega.pizzeria.persistence.entity.PizzaEntity;
import com.ortega.pizzeria.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    @Autowired
    private PizzaService pizza_Service;

    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll(){
        List<PizzaEntity> pizzas = pizza_Service.getAllPizzas();
        return new ResponseEntity<>(pizzas, HttpStatus.OK);
    }
}
