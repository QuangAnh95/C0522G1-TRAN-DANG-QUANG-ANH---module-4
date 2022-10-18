package vn.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.product.model.Produce;
import vn.product.service.IProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

@GetMapping("/")
    public String show(Model model){
    List<Produce> produceList = productService.findAll();
    model.addAttribute("produceList",produceList);
    return "/list";
}

@GetMapping("/create")
    public String create(Model model){
    model.addAttribute("produce", new Produce());
    return "/create";
}

@PostMapping("/save")
    public String save(Produce produce, RedirectAttributes redirectAttributes){
    productService.save(produce);
    redirectAttributes.addFlashAttribute("mess","create success");
    return "redirect:/";
}

@GetMapping("/edit/(id)")
    public String edit(@PathVariable int id, Model model){
    model.addAttribute("product",productService.findById(id));
    return "/list";
}
@PostMapping("/update")
    public String update (@ModelAttribute Produce produce, RedirectAttributes redirectAttributes){
    productService.update(produce);
    redirectAttributes.addFlashAttribute("mess","update success");
    return "redirect:/";
}
}
