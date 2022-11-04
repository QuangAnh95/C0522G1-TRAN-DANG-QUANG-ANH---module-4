package com.security.controller;

import com.security.model.Product;
import com.security.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/product")
    public String showList(@PageableDefault(value = 3) Pageable pageable, @RequestParam(value = "pr", defaultValue = "") String pr, Model model) {
        model.addAttribute("pr", pr);
        model.addAttribute("productList", productService.findAllByNameContaining(pageable, pr));
        return "product";
    }

    @GetMapping("/{id}-delete")
    public String formDelete(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("Xóa sản phẩm"+ product.getName()+ "thành công");
        return "redirect:/product";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
     model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("create Product"+"OK");
        return "redirect:/product";
    }

    @GetMapping("/{id}-update")
    public String formEdit(@PathVariable Long id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("Update Ok");
        return "redirect:/product";
    }

}
