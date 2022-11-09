package com.casestudy.controller;

import com.casestudy.model.facility.Facility;
import com.casestudy.repository.facility.IFacilityRepository;
import com.casestudy.repository.facility.ITypeFacilityRepository;
import com.casestudy.service.facility.IFacilityService;
import com.casestudy.service.facility.IRenTypeService;
import com.casestudy.service.facility.ITypeFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private ITypeFacilityService typeFacilityService;

    @Autowired
    private IRenTypeService renTypeService;

    @GetMapping("")
    public String formList(@PageableDefault(value = 5)Pageable pageable,
                           @RequestParam(value = "nameSearch",defaultValue = "") String nameSearch,
                           @RequestParam(value = "typeFacilitySearch",defaultValue = "") String typeFacilitySearch,
                           @RequestParam(value = "renTypeSearch",defaultValue = "") String renTypeSearch,
                           Model model){
        model.addAttribute("typeFacility",typeFacilityService.findAll());
        model.addAttribute("renType",renTypeService.findAll());
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("typeFacilitySearch",typeFacilitySearch);
        model.addAttribute("renTypeSearch",renTypeSearch);
        model.addAttribute("facilityList",facilityService.searchFacility(nameSearch,typeFacilitySearch,renTypeSearch,pageable));
        return "/facility/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam(value = "idDelete") int id, RedirectAttributes redirectAttributes) {
        facilityService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("mess", "xóa thành công");
        return "redirect:/facility";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("facility",new Facility());
        model.addAttribute("typeFacility",typeFacilityService.findAll());
        model.addAttribute("renType",renTypeService.findAll());
        return "/facility/create";
    }

    @PostMapping("/save")
    public String saveFacility(Facility facility,RedirectAttributes redirectAttributes,Model model){
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","Tạo mới thành công ");
        return "redirect:/facility/create";
    }

    @GetMapping("/update/{id}")
    public String formUpdate(@PathVariable long id, Model model){
        model.addAttribute("facility",facilityService.findByIdFacility(id));
        model.addAttribute("renType",renTypeService.findAll());
        model.addAttribute("typeFacility",typeFacilityService.findAll());
        return "/facility/update";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute Facility facility,RedirectAttributes redirectAttributes){
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        return "redirect:/facility";
    }
}
