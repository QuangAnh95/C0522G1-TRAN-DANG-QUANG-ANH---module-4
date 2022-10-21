package com.blog.controller;

import com.blog.service.blog.IBlogService;
import com.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public ModelAndView showList(@PageableDefault(value = 1) Pageable pageable) {
        return new ModelAndView("blog", "blogList", blogService.findAll(pageable));
    }

    @GetMapping("/create")
    

}
