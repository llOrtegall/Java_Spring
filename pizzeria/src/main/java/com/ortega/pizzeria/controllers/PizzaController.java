package com.ortega.pizzeria.controllers;

import com.ortega.pizzeria.persistence.entity.PizzaEntity;
import com.ortega.pizzeria.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> getPizzaById(@PathVariable int idPizza){
        PizzaEntity pizza = pizza_Service.getPizzaById(idPizza);
        if (pizza != null) {
            return new ResponseEntity<>(pizza, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PizzaEntity> insertNewPizza(@RequestBody PizzaEntity newPizza){
        return ResponseEntity.ok(pizza_Service.save(newPizza));
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> updatePizza(@RequestBody PizzaEntity newPizza){
        if(newPizza.getIdPizza() != null && this.pizza_Service.existPizzaById(newPizza.getIdPizza())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PizzaEntity savedPizza = pizza_Service.save(newPizza);
        return new ResponseEntity<>(savedPizza, HttpStatus.CREATED);
    }
}
