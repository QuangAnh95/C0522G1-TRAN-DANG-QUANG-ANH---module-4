package com.casestudy.repository.employee;

import com.casestudy.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployRepository extends JpaRepository<Employee,Long> {
}
