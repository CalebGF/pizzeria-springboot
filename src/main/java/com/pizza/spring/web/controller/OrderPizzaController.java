package com.pizza.spring.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.spring.persistence.entity.Order;
import com.pizza.spring.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderPizzaController {
    private final OrderService orderPizzaService;

    public OrderPizzaController(OrderService orderPizzaService) {
        this.orderPizzaService = orderPizzaService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(this.orderPizzaService.getAll());
    }

    @GetMapping("/today")
    public ResponseEntity<List<Order>> getTodayOrders() {
        return ResponseEntity.ok(this.orderPizzaService.getTodayOrders());
    }

    @GetMapping("/outside")
    public ResponseEntity<List<Order>> getOutsideOrders() {
        return ResponseEntity.ok(this.orderPizzaService.getOutsideOrders());
    }
}
