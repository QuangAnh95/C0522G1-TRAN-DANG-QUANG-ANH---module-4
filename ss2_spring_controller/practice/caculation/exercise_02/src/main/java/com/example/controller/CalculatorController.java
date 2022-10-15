package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @RequestMapping()
    public String home(){
        return "/index";
    }

    @RequestMapping("/convert")
    public ModelAndView convert(@RequestParam double num1, @RequestParam double num2 , @RequestParam String choose ){
          return new ModelAndView("/index","result",iCalculatorService.change(num1,num2,choose));
    }

}
