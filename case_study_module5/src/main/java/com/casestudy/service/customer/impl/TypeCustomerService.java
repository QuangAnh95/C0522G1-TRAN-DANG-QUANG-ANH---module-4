package com.casestudy.service.customer.impl;

import com.casestudy.model.customers.TypeCustomers;
import com.casestudy.repository.customers.ITypeCustomerRepository;
import com.casestudy.service.customer.ITypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeCustomerService implements ITypeCustomerService {

    @Autowired
    private ITypeCustomerRepository typeCustomerRepository;

    @Override
    public List<TypeCustomers> findAll() {
        return typeCustomerRepository.findAll();
    }
}
