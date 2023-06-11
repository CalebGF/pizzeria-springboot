package com.pizza.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.spring.persistence.entity.Pizza;
import com.pizza.spring.service.PizzaService;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    @Autowired
    private final PizzaService pizzaService;
    
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> getAll() {
        return ResponseEntity.ok(this.pizzaService.getAll());
    }

    @GetMapping("/available")
    public ResponseEntity<List<Pizza>> getAllAvailable() {
        return ResponseEntity.ok(this.pizzaService.getAllAvailable());
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Pizza> getByName(@PathVariable String name) {
        return ResponseEntity.ok(this.pizzaService.getByName(name));
    }

    @GetMapping("/search/with/{description}")
    public ResponseEntity<List<Pizza>> getByDescription(@PathVariable String description) {
        return ResponseEntity.ok(this.pizzaService.getByDescription(description));
    }

    @GetMapping("/search/without/{description}")
    public ResponseEntity<List<Pizza>> getByNotDescription(@PathVariable String description) {
        return ResponseEntity.ok(this.pizzaService.getByNotDescription(description));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.pizzaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Pizza> add(@RequestBody Pizza pizza) {
        if(pizza.getPizzaId() == null || !pizzaService.exists(pizza.getPizzaId())){
            return ResponseEntity.ok(this.pizzaService.save(pizza));
        }

        return ResponseEntity.badRequest().build();
    }
    
    @PutMapping
    public ResponseEntity<Pizza> update(@RequestBody Pizza pizza) {
        if(pizza.getPizzaId() != null && pizzaService.exists(pizza.getPizzaId())){
            return ResponseEntity.ok(this.pizzaService.save(pizza));
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if(pizzaService.exists(id)){
            this.pizzaService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    
}
