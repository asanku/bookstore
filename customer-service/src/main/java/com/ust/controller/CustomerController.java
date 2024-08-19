package com.ust.controller;


import com.ust.domain.Customer;
import com.ust.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer addCustomer(@Valid @RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomerById(@PathVariable int id, @Valid @RequestBody Customer customer) {
        return customerService.updateCustomerById(id, customer);
    }

    public void deleteCustomerById(@PathVariable int id) {
        customerService.deleteCustomerById(id);
    }

}
