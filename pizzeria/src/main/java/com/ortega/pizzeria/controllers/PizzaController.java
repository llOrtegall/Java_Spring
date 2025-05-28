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
        return ResponseEntity.ok(this.pizza_Service.getAllPizzas());
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> getPizzaById(@PathVariable int idPizza){
        PizzaEntity pizza = pizza_Service.getPizzaById(idPizza);
        if (pizza != null) {
            return ResponseEntity.ok(pizza);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PizzaEntity> insertNewPizza(@RequestBody PizzaEntity newPizza){
        try {
            if(newPizza.getIdPizza() == null || !this.pizza_Service.existPizzaById(newPizza.getIdPizza())){
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(this.pizza_Service.save(newPizza));
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> updatePizza(@RequestBody PizzaEntity updatedPizza){
        if(updatedPizza.getIdPizza() != null && this.pizza_Service.existPizzaById(updatedPizza.getIdPizza())){
            try {
                return ResponseEntity.ok(this.pizza_Service.save(updatedPizza));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
