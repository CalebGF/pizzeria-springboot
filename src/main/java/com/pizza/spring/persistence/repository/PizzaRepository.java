package com.pizza.spring.persistence.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.pizza.spring.persistence.entity.Pizza;

public interface PizzaRepository extends ListCrudRepository<Pizza, Integer>{

    List<Pizza> findAllByAvailableTrueOrderByPriceAsc();

    Pizza findByAvailableTrueAndNameIgnoreCaseContaining(String name);
    /*
     * This method returns a list of pizzas whose description contains the given string, ignoring case.
     */
    List<Pizza> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    
    /*
     * This method returns a list of pizzas whose description does not contain the given string, ignoring case.
     */
    List<Pizza> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
}
