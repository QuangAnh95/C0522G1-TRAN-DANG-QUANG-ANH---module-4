package vn.mailbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.mailbox.model.MailBox;
import vn.mailbox.service.IMailBoxService;

import java.util.List;

@Controller
public class MailBoxController {
    @Autowired
    private IMailBoxService mailBoxService;

    @GetMapping("/")
    public String showMailBoxList(Model model){
        List<MailBox> mailBoxList = mailBoxService.findAll();
        model.addAttribute("mailBoxList",mailBoxList);
        return "list";
    }

   @GetMapping("/update")
   public String upDate(@RequestParam int id, Model model){
        model.addAttribute("mailBox",mailBoxService.findId(id));
        model.addAttribute("languages",mailBoxService.findLanguages());
        model.addAttribute("pageSize",mailBoxService.findPageSize());
        return "form";
   }

   @PostMapping("/save")
    public String save(@ModelAttribute MailBox mailBox, RedirectAttributes redirectAttributes){
        mailBoxService.upDate(mailBox);
        redirectAttributes.addFlashAttribute("mess","UpDate Thành Công");
        return "redirect:/";
   }
}
