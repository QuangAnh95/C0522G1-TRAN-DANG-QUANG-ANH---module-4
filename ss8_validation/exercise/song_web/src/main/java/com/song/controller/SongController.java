package com.song.controller;

import com.song.dto.SongDto;
import com.song.model.Song;
import com.song.repository.ISongRepository;
import com.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String listSong(@PageableDefault(value = 1) Pageable pageable,
                           @RequestParam(value = "title", defaultValue = "") String title,
                           Model model) {
        model.addAttribute("listSong", songService.findByNameContaining(pageable, title));
        return "/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/save")
    public String saveSong(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "list";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            redirectAttributes.addFlashAttribute("mess", "Create Song OK");
            return "redirect:/";
        }
    }

    @GetMapping("/formUpdate")
    public String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String updateSong(@ModelAttribute Song song,RedirectAttributes redirectAttributes){
            songService.save(song);
            redirectAttributes.addFlashAttribute("mess","Update Ok");
            return "/";
    }
}

