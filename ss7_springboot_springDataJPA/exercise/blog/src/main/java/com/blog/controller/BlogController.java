package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.blog.IBlogService;
import com.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
                                 @RequestParam(value = "bl",defaultValue = "") String bl,
                                 Model model) {
        model.addAttribute("bl1",bl);
        model.addAttribute("blogList",blogService.findAllByTitleContaining(pageable,bl));
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

    @GetMapping("/{id}-delete")
    public String deleteForm(@PathVariable int id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("messDelete","Delete Ok");
        return "redirect:/";
    }

    @GetMapping("/{id}-update")
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("messUpdate","UPdate Ok");
        return "redirect:/";
    }


}
