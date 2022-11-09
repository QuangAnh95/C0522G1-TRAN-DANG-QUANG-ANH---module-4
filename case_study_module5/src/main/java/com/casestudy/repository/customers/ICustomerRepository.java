package com.casestudy.repository.customers;

import com.casestudy.model.customers.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customers,Long> {
    @Query(value = "select customers.* from `customers` join type_customers on customers.id_type_customer = type_customers.id_type_customer where customers.name_customer like %:nameSearch% and customers.email_customer like %:emailSearch% and type_customers.name_type_customer like %:customerType% and customers.is_delete=0",nativeQuery = true)
    Page<Customers> searchCustomer(@Param("nameSearch") String nameSearch,
                                   @Param("emailSearch") String emailSearch,
                                    @Param("customerType") String customerType,
                                    Pageable pageable);



    @Modifying
    @Query(value = "update customers set is_delete = 1 where id_customer = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") int id);

    Customers findByIdCustomer(long id);
}

