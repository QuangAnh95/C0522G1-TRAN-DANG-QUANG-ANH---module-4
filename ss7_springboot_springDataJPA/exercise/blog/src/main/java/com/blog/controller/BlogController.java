package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.blog.IBlogService;
import com.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public ModelAndView showList(@PageableDefault(value = 1) Pageable pageable) {
        return new ModelAndView("blog", "blogList", blogService.findAll(pageable));
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("blogList", new Blog());
        model.addAttribute("categoryList",categoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","create blog  OK");
        return "redirect:/";
    }

}
