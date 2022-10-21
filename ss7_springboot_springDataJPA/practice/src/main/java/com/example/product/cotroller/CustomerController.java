package com.example.product.cotroller;

import com.example.product.model.Customer;
import com.example.product.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;


    @GetMapping("")
    public String showCustomerList(Model model) {
        model.addAttribute("customerlist", customerService.findAll());
        return "/customer";
    }

    @GetMapping("/create")
    public String show(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute Customer customer,
                                 RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Create customer" + customer.getFirstName() + "Ok");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("klt") String nameSeach, Model model) {
        model.addAttribute("customer", customerService.findCustomerByIdContaining(nameSeach));
        return "/";

    }

}
