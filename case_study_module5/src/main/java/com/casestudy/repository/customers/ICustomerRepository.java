package com.casestudy.repository.customers;

import com.casestudy.model.customers.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



@Transactional
public interface ICustomerRepository extends JpaRepository<Customers,Long> {
    @Query(value = "select * from customers where name_customer like %:nameSearch% and " +
            "email_customer like %:emailSearch% and id_type_customer = :typeCustomer and   is_delete = 0;",nativeQuery = true)

    Page<Customers> searchCustomer(@Param("nameSearch") String nameSearch, @Param("emailSearch") String emailSearch,
                                   @Param("typeCustomer") int typeCustomer , Pageable pageable);



    @Modifying
    @Query(value = "update customers set is_delete = 1 where id_customer = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);
}
