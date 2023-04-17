package com.codegym.register_course.controller;

import com.codegym.register_course.model.Curriculum;
import com.codegym.register_course.service.ICurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/curriculum")
public class CurriculumController {
    @Autowired
    private ICurriculumService curriculumService;

    @GetMapping("")
    public String listCurriculum(Model model){
        model.addAttribute("curriculum", curriculumService.findAllCurriculum());
        return "/admin/curriculum/curriculum";
    }

    @GetMapping("/delete")
    public String deleteCurriculum(@RequestParam Integer curriculumID) {
        curriculumService.removeById(curriculumID);
        return "redirect:/admin/curriculum/curriculum";
    }
    @GetMapping("admin/curriculum")
    public String findByName(Model model, @RequestParam String searchName,Integer page){
        Sort sort = Sort.by(searchName);
        model.addAttribute("searchName", curriculumService.findAllByName(searchName, PageRequest.of(page,2,sort)));
        return "redirect:/admin/curriculum/curriculum";
    }

    @GetMapping("/create")
    public String showCreate(
            Model model
    ){
        model.addAttribute("curriculumCreate", new Curriculum());
        return "/admin/curriculum/create-curriculum";
    }

    @PostMapping("/create")
    public String createCurriculum(Curriculum curriculum){
        curriculumService.save(curriculum);
        return "redirect:/admin/curriculum";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(
            Model model,
            @PathVariable("id") Integer id
    ){
        model.addAttribute("curriculumEdit", curriculumService.findById(id));
        return "/admin/curriculum/edit-curriculum";
    }

    @PostMapping("/edit")
    public String edit(Curriculum curriculum){
        curriculumService.save(curriculum);
        return "redirect:/admin/curriculum";
    }

}
