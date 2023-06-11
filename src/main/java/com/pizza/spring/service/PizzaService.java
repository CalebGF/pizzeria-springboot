package com.pizza.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pizza.spring.persistence.entity.Pizza;
import com.pizza.spring.persistence.repository.PizzaRepository;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getAll() {
        return pizzaRepository.findAll();
    }

    public List<Pizza> getAllAvailable() {
        return pizzaRepository.findAllByAvailableTrueOrderByPriceAsc();
    }

    public Pizza getByName(String name) {
        return pizzaRepository.findByAvailableTrueAndNameIgnoreCaseContaining(name);
    }

    public List<Pizza> getByDescription(String description) {
        return pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(description);
    }

    public List<Pizza> getByNotDescription(String description) {
        return pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(description);
    }

    public Pizza getById(Integer id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    public Pizza save(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public boolean exists(Integer id) {
        return pizzaRepository.existsById(id);
    }

    public void delete(Integer id) {
        pizzaRepository.deleteById(id);
    }
}
