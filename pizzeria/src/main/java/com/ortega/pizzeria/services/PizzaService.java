package com.ortega.pizzeria.services;

import com.ortega.pizzeria.persistence.entity.PizzaEntity;
import com.ortega.pizzeria.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository repo_pizza;

    @Autowired
    public PizzaService(PizzaRepository repo_pizza) {
        this.repo_pizza = repo_pizza;
    }

    public List<PizzaEntity> getAllPizzas() {
        return this.repo_pizza.findAll();
    }

    public PizzaEntity getPizzaById(int id) {
        return this.repo_pizza.findById(id).orElse(null);
    }

    public PizzaEntity save(PizzaEntity newPizza){
        return this.repo_pizza.save(newPizza);
    }

    public Boolean existPizzaById(int id){
        return  this.repo_pizza.existsById(id);
    }
}
