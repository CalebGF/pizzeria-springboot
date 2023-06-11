package com.pizza.spring.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pizza.spring.persistence.entity.Order;
import com.pizza.spring.persistence.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderPizzaRepository;

    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";
    
    public OrderService(OrderRepository orderPizzaRepository) {
        this.orderPizzaRepository = orderPizzaRepository;
    }

    public List<Order> getAll() {
        return orderPizzaRepository.findAll();
    }

    public List<Order> getTodayOrders() {
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return orderPizzaRepository.findAllByDateAfter(today);
    }

    public List<Order> getOutsideOrders() {
        List<String> methods = List.of(DELIVERY, CARRYOUT);
        return orderPizzaRepository.findAllByMethodIn(methods);
    }
}
