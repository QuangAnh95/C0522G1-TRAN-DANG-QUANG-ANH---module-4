package com.casestudy.repository.customers;

import com.casestudy.model.customers.TypeCustomers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ITypeCustomerRepository extends JpaRepository<TypeCustomers,Long> {
}
