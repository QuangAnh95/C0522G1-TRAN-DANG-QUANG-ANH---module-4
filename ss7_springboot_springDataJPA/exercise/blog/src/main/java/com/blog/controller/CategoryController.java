package com.blog.controller;

import com.blog.model.Category;
import com.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Pageable;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String listCategory(@PageableDefault(value = 10) Pageable pageable,
                               @RequestParam(value = "nameCategory",defaultValue = "") String nameCategory,
                               Model model){
        model.addAttribute("listCategory",iCategoryService.findByNameCategoryContaining(pageable,nameCategory));
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("category",new Category());
        return "/create";
    }

    @PostMapping("/create")
    public String saveCreate(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("messCreate","Create thanh cong "+category.getNameCategory());
        return "redirect:/";
    }

    @GetMapping("/{id}-delete")
    public String showFormDelete(@PathVariable int id, Model model){
        model.addAttribute("category",iCategoryService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String deleteCategory(@ModelAttribute Category category,RedirectAttributes redirectAttributes){
        iCategoryService.delete(category.getIdCategory());
        redirectAttributes.addFlashAttribute("messDelete","Xoa thanh cong "+category.getNameCategory());
        return "redirect:/";
    }

    @GetMapping("/{id}-update")
    public String showFormUpdate(@PathVariable int id, Model model){
        model.addAttribute("category",iCategoryService.findById(id));
        return "/update";
    }


    @PostMapping("/update")
    public String saveCreateUpdate(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("messCreate","Update thanh cong "+category.getNameCategory());
        return "redirect:/";
    }

}
