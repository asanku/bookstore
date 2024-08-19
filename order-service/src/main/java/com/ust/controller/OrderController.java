package com.ust.controller;

import com.ust.domain.Order;
import com.ust.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getOrders() {

        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable long id) {

        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order addOrder(@Valid @RequestBody Order order) {

        return orderService.placeOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable long id, @Valid @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable long id) {

        orderService.deleteOrder(id);
    }

    @PostMapping("/{id}/cancel")
    public void cancelOrder(@PathVariable long id) {
        orderService.cancelOrder(id);
    }
}
