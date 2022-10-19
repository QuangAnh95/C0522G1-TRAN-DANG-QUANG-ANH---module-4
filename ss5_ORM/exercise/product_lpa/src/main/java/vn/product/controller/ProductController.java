package vn.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vn.product.service.IProductService;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private IProductService productService;


//    @GetMapping("/")
//    public  String home(){
//        return "/list";
//    }

@RequestMapping(value = "/list",method = RequestMethod.GET)
public ModelAndView showProductList(){
    return new ModelAndView("product",
            "productlist", productService.findAll());
}

    @PostMapping("/list")
    public ModelAndView showStudentList1(){
        return new ModelAndView("student",
                "studentList", productService.findAll());
    }
}
