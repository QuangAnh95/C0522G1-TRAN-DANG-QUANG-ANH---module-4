package vn.dictionary.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.dictionary.model.Dictionary;
import vn.dictionary.service.IDictionnaryService;

import java.util.List;

@Controller
@RequestMapping
public class DictionnaryCotroller {
    @Autowired
     private IDictionnaryService service;
    @GetMapping
    public String show(){
        return "list";
    }

    @PostMapping("/check")
    public String meaing(@RequestParam String keyword, Model model) {
        List<Dictionary> dictionaryLanguages = service.findAll();
        for (int i = 0; i < dictionaryLanguages.size(); i++) {
            if (keyword.equalsIgnoreCase(dictionaryLanguages.get(i).getVietnamese())) {
                model.addAttribute("word", dictionaryLanguages.get(i).getEnglish());
                model.addAttribute("key", keyword);
                break;
            } else {
                model.addAttribute("word", "Not Found !");
            }
        }
        return "list";
    }

}
