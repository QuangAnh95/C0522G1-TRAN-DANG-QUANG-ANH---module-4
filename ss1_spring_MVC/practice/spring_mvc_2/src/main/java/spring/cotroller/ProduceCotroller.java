package spring.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.model.Produce;
import spring.service.IProduceService;

import java.util.List;

@Controller
@RequestMapping()
public class ProduceCotroller {
    @Autowired
    private IProduceService service;

    @GetMapping
    public String showList(Model model){
        List<Produce> produceList = service.findAll();
        model.addAttribute("produceList", produceList);
        return "list";
    }
    }



