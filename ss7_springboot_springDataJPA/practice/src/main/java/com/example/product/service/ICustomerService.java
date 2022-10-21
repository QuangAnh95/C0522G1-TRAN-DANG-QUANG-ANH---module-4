package com.example.product.service;

import com.example.product.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    List<Customer> findCustomerByFirstName(String nameSeach);
}
