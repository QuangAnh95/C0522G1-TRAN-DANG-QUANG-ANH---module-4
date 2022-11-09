package com.casestudy.controller;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.contract.ContractDetail;
import com.casestudy.service.contract.IAttachFacilityService;
import com.casestudy.service.contract.IContractDetailService;
import com.casestudy.service.contract.IContractService;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.employee.IEmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployService employService;

    @GetMapping("")
    public String showContract(@PageableDefault(value = 3) Pageable pageable, Model model){
        model.addAttribute("contractList",contractService.findAllDto(pageable));
        model.addAttribute("contractDetailList",contractDetailService.findAll());
        model.addAttribute("attachFacility",attachFacilityService.findAll());
        model.addAttribute("customerList",customerService.findAll());
        model.addAttribute("employeeList",employService.findAll());
        model.addAttribute("contract",new Contract());
        model.addAttribute("contractDetail",new ContractDetail());
        return "/contract/list";

    }
}
