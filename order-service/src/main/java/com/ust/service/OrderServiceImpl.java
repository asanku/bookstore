package com.ust.service;

import com.ust.DTO.Book;
import com.ust.domain.Order;
import com.ust.exceptions.OrderNoStockException;
import com.ust.exceptions.OrderNotFoundException;
import com.ust.feignClient.BookClient;
import com.ust.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookClient bookClient;


    public List<Order> getAllOrders() {
        log.debug("getAllOrders");
        return orderRepository.findAll();
    }

    public Order getOrderById(long id) {
        log.debug("getOrderById : {}",id);
        Order order = orderRepository.findById(id).orElseThrow(()-> new OrderNotFoundException("order not found"));
        return order;
    }

    @Override
    public Order placeOrder(Order order) {
        log.debug("placeOrder : {}",order);
        /*
        orderRepository.findById(order.getId())
                .ifPresent(existingOrder -> {
                    log.error("order already exists with id :{}",existingOrder.getId());
                    throw new DuplicateOrderException("Order already exists");
                });
                */
        Book book= bookClient.getBookById(order.getBook_id());
        if(book.getStock()<order.getQuantity()){
            throw new OrderNoStockException("no enough Order");
        }
        /*
        else {
            bookClient.updateStock(book.getId(), book.getStock() - order.getQuantity());
            order.setStatus("CONFIRMED");
        }

         */

        return orderRepository.save(order);
    }

    public Order updateOrder(long id, Order order) {
        log.debug("updateOrder {}",order);
        var existingOrder= getOrderById(id);
        existingOrder.setCustomer_id(order.getCustomer_id());
        existingOrder.setBook_id(order.getBook_id());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setStatus(order.getStatus());
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(long id) {
        log.debug("deleteOrder {}",id);
        var existingOrder= orderRepository.findById(id)
                .orElseThrow(()-> new OrderNotFoundException("order not found"));
        orderRepository.delete(existingOrder);
    }

    @Override
    public void cancelOrder(long id) {
        log.debug("cancelOrder {}",id);
        var existingOrder= getOrderById(id);
        existingOrder.setStatus("CANCELLED");
        orderRepository.save(existingOrder);
    }
}
