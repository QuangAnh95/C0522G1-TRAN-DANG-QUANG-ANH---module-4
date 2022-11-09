package com.casestudy.repository.contract;

import com.casestudy.dto.IContractDto;
import com.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface IContractRepository extends JpaRepository<Contract,Long> {

    @Query(value = "select contract.id_contract as contractId, contract.start_date as startDate, " +
            "            contract.end_date as endDate, contract.deposit as deposit, facility.name_facility as facilityName, " +
            "            employee.name_employee as employeeName, customers.name_customer as customerName, " +
            "            (facility.cost + contract.deposit + sum(ifnull(contract_detail.quantity, 0) * ifnull(attach_facility.cost, 0))) " +
            "            as totalMoney " +
            "            from `contract` " +
            "            left join `facility` on contract.id_facility = facility.id_facility " +
            "            left join `employee` on contract.id_employee = employee.id_employee " +
            "            left join `customers` on contract.id_customer = customers.id_customer " +
            "            left join `contract_detail` on contract_detail.id_contract = contract.id_contract " +
            "            left join `attach_facility` on attach_facility.id_attach_facility = contract_detail.id_attach_facility " +
            "            where contract.is_delete = 0 " +
            "            group by contract.id_contract ",
    countQuery = "select count(*)" +
            "from `contract`" +
            " left join `facility` on contract.id_facility = facility.id_facility " +
            "left join `employee` on contract.id_employee = employee.id_employee " +
            "left join `customers` on contract.id_customer = customers.id_customer " +
            "left join `contract_detail` on contract_detail.id_contract = contract.id_contract " +
            "left join `attach_facility` on attach_facility.id_attach_facility = contract_detail.id_attach_facility " +
            "where contract.is_delete = 0 " +
            "group by contract.id_contract ",
    nativeQuery = true)
    Page<IContractDto>findAllDto(Pageable pageable);


    @Query(value = "select contract.id_contract as contractId, contract.start_date as startDate," +
            "            contract.end_date as endDate, contract.deposit as deposit, facility.name_facility as facilityName," +
            "            employee.name_employee as employeeName, customers.name_customer as customerName," +
            "            (facility.cost + contract.deposit + sum(ifnull(contract_detail.quantity, 0) * ifnull(attach_facility.cost, 0)))" +
            "            as totalMoney" +
            "            from contract" +
            "            left join facility on contract.id_facility = facility.id_facility" +
            "            left join employee on contract.id_employee = employee.id_employee" +
            "            left join customers on contract.id_customer = customers.id_customer" +
            "            left join contract_detail on contract_detail.id_contract = contract.id_contract" +
            "            left join attach_facility on attach_facility.id_attach_facility = contract_detail.id_attach_facility" +
            "            where contract.is_delete = 0" +
            "            group by contract.id_contract",
    nativeQuery = true)
    List<Contract> findAll();
}
