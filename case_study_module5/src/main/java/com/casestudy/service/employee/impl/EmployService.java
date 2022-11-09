package com.casestudy.service.employee.impl;

import com.casestudy.model.employee.Employee;
import com.casestudy.repository.employee.IEmployRepository;
import com.casestudy.service.employee.IEmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployService implements IEmployService {
    @Autowired
    private IEmployRepository employRepository;

    @Override
    public List<Employee> findAll() {
        return employRepository.findAll();
    }
}
