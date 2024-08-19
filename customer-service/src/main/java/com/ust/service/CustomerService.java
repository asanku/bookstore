package com.ust.service;

import com.ust.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    Customer addCustomer(Customer customer);
    Customer updateCustomerById(int id, Customer customer);
    void deleteCustomerById(int id);
}
