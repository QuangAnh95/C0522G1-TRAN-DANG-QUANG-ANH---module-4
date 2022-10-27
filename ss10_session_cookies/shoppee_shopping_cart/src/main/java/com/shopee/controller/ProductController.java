package com.shopee.controller;

import com.shopee.dto.CartDto;
import com.shopee.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/shopee")
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }
    @Autowired
    private IProductService productService;




}
