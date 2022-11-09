package com.casestudy.controller;

import com.casestudy.dto.CustomerDto;
import com.casestudy.model.customers.Customers;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.customer.ITypeCustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/customer";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        model.addAttribute("typeCustomer",typeCustomerService.findAll());
        return "customer/create";

    }

    @PostMapping("/save")
    public String createCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model){
        model.addAttribute("typeCustomer",typeCustomerService.findAll());
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "/customer/create";
        }else {
            Customers customers = new Customers();
            BeanUtils.copyProperties(customerDto,customers);
            customerService.save(customers);
            redirectAttributes.addFlashAttribute("mess","tạo mới thành công");
            return "redirect:/customer/create";
        }
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
        redirectAttributes.addFlashAttribute("mess","chỉnh sửa thành công");
        return "redirect:/customer";
    }



}
