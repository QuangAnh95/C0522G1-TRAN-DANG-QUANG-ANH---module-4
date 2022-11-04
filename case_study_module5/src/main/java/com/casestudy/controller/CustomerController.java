package com.casestudy.controller;

import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.customer.ITypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ITypeCustomerService typeCustomerService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 5)Pageable pageable,
                           @RequestParam(value = "nameSearch",defaultValue = "") String nameSearch,
                           @RequestParam(value = "emailSearch", defaultValue = "") String emailSearch,
                           @RequestParam(value = "typeCustomer", defaultValue = "") int typeCustomer, Model model){

        model.addAttribute("typeCustomer", typeCustomerService.findAll());
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("emailSearch",emailSearch);
        model.addAttribute("typeCustomer",typeCustomer);
        model.addAttribute("customerList",customerService.searchCustomer(nameSearch,emailSearch,typeCustomer,pageable));
        return "/customer/list";

    }

//    @GetMapping("")
//    public String showList(Model model){
//        model.addAttribute("customerList",customerService.findAll());
//        return "/customer/list";
//    }


}
