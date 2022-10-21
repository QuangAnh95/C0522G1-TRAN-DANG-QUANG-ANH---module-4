package com.example.product.service;

import com.example.product.model.Customer;
import com.example.product.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public List<Customer> findCustomerByFirstName(String nameSeach) {
        return customerRepository.findCustomerByFirstNameContains(nameSeach);
    }
}
