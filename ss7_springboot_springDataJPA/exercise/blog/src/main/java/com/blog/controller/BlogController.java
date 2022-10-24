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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public String showList(@PageableDefault(value = 3) Pageable pageable,
                                 @RequestParam(value = "bl",defaultValue = "") String blaaaa,
                                 Model model) {
        model.addAttribute("bl1",blaaaa);
        model.addAttribute("blogList",blogService.findAllByTitleContaining(pageable,blaaaa));
        return "blog";
    }
    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("blogList", new Blog());
        model.addAttribute("categoryList", categoryService.findAll());

        return "create";
    }

    @PostMapping("/save")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "create blog  OK");
        return "redirect:/";
    }


}
