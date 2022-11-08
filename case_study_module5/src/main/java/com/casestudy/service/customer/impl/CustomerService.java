package com.casestudy.service.customer.impl;

import com.casestudy.model.customers.Customers;
import com.casestudy.repository.customers.ICustomerRepository;
import com.casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customers> searchCustomer(String nameSearch, String emailSearch, String customerType, Pageable pageable) {
        return customerRepository.searchCustomer("%"+nameSearch+"%","%"+emailSearch+"%","%"+customerType+"%",pageable);
    }

    @Override
    public void deleteLogical(Integer id) {
        customerRepository.deleteLogical(id);
    }

    @Override
    public List<Customers> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customers customers) {
        customerRepository.save(customers);
    }

    @Override
    public Customers findByIdCustomer(long id) {
        return customerRepository.findByIdCustomer(id);
    }


}
