package com.casestudy.controller;

import com.casestudy.Dto.CustomerDto;
import com.casestudy.model.customers.Customers;
import com.casestudy.model.customers.TypeCustomers;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.customer.ITypeCustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



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
                            @RequestParam(value = "customerType",defaultValue = "") String customerType,
                            Model model){

        model.addAttribute("typeCustomer", typeCustomerService.findAll());
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("emailSearch",emailSearch);
        model.addAttribute("customerType",customerType);
        model.addAttribute("customerList",customerService.searchCustomer(nameSearch,emailSearch,customerType,pageable));
        return "/customer/list";

    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam(value = "idDelete") int id, RedirectAttributes redirectAttributes){
        customerService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("message","Delete customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("customer", new Customers());
        model.addAttribute("typeCustomer",typeCustomerService.findAll());
        return "customer/create";

    }

    @PostMapping("/save")
    public String createCustomer(Customers customers, RedirectAttributes redirectAttributes, Model model){
        customerService.save(customers);
        redirectAttributes.addFlashAttribute("mess","tạo thành công");
        return "redirect:/customer/create";
    }

    @GetMapping("/update/{id}")
    public String formUpdate(@PathVariable long id, Model model){
        model.addAttribute("customer",customerService.findByIdCustomer(id));
        model.addAttribute("typeCustomer",typeCustomerService.findAll());
        return "customer/update";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customers customers, RedirectAttributes redirectAttributes){
        customerService.save(customers);
        redirectAttributes.addFlashAttribute("mess","update Ok");
        return "redirect:/customer";
    }



}
