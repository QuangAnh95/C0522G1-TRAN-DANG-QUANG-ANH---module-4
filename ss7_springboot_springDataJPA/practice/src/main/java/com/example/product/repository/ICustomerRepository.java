package com.example.product.repository;

import com.example.product.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
List<Customer> findCustomerByFirstNameContains(String nameSeach);

}
