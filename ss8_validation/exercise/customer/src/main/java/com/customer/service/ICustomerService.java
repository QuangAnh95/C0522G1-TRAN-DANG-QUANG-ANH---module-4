package com.customer.service;

import com.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    void save(Customer customer);
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
}
