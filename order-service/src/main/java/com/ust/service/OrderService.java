package com.ust.service;

import com.ust.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order getOrderById(long id);
    Order placeOrder(Order order);
    Order updateOrder(long id,Order order);
    void deleteOrder(long id);
    void cancelOrder(long id);
}
