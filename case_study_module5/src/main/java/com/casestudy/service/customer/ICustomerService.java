package com.casestudy.service.customer;

import com.casestudy.model.customers.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerService {
    Page<Customers> searchCustomer( String nameSearch, String emailSearch,int typeCustomer , Pageable pageable);

    void deleteLogical( Integer id);

    List<Customers> findAll();

}
