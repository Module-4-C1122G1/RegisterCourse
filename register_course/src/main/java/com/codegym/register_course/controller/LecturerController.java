package com.codegym.register_course.controller;

import com.codegym.register_course.service.ILecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lecturer")
public class LecturerController {
    private final ILecturerService service;

    public LecturerController(ILecturerService service) {
        this.service = service;
    }

    @GetMapping("")
    public String showList(
            Model model
    ){
        model.addAttribute("lecturer", service.findAllLecturer());
        return "/teacher";
    }
    @GetMapping("admin/lecturer")
    public String showListAdmin(
            Model model
    ){
        model.addAttribute("lecturer1", service.findAllLecturer());
        return "/admin/lecturer";
    }
}
