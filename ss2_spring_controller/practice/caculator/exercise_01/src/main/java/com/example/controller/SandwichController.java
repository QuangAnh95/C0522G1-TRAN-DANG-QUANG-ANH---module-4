package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    @GetMapping("")
    public String home(){
        return "/index";
    }

    @GetMapping("/save")
    public String save(@RequestParam("choose") String[] choose , Model model){
        model.addAttribute("result",choose);
        return "/index";
    }
}
