package com.codegym.register_course.controller;

import com.codegym.register_course.service.ICurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
