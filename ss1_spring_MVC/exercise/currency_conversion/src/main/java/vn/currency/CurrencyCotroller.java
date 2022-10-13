package vn.currency;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
public class CurrencyCotroller {
    @GetMapping()
    public String show(Model model) {
        return "/list";
    }

    @PostMapping("/resutl")
    public String cacalate(@RequestParam int USA, Model model) {
        int VND = USA * 23000;
        model.addAttribute("USA", USA);
        model.addAttribute("VND",VND);
        return "/list";
    }

}
