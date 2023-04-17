package com.codegym.register_course.controller;

import com.codegym.register_course.service.ICurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/curriculum")
public class CurriculumController {
    @Autowired
    private ICurriculumService curriculumService;

    @GetMapping("")
    public String listCurriculum(Model model){
        model.addAttribute("curriculum", curriculumService.findAllCurriculum());
        return "/admin/curriculum";
    }

    @GetMapping("/admin/curriculum/delete")
    public String deleteCurriculum(@RequestParam Integer curriculumID) {
        curriculumService.removeById(curriculumID);
        return "redirect:/admin/curriculum";
    }
    @GetMapping("admin/curriculum")
    public String findByName(Model model, @RequestParam String searchName,Integer page){
        Sort sort = Sort.by(searchName);
        model.addAttribute("searchName", curriculumService.findAllByName(searchName, PageRequest.of(page,2,sort)));
        return "redirect:/admin/curriculum";
    }

}
