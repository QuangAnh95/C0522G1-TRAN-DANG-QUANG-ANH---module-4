package com.customer.controller;

import com.customer.dto.CustomerDto;
import com.customer.model.Customer;
import com.customer.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    @Autowired
    public ICustomerService customerService;

    @GetMapping("/")
    public ModelAndView showList(@PageableDefault(value = 2)Pageable pageable){
        return new ModelAndView("customer","customerList",customerService.findAll(pageable));
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        return "create";
    }

    @PostMapping("/save")
    public String createCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
        new CustomerDto().validate(customerDto,bindingResult);

        if (bindingResult.hasFieldErrors()){
            return "create";
        }
        else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("mess","Create Customer OK");
            return "redirect:/";
        }
    }


}
