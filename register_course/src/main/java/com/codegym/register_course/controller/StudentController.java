package com.codegym.register_course.controller;

import com.codegym.register_course.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/student")
public class StudentController {
    private final IStudentService iStudentService;

    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }
    @GetMapping("")
    public String listStudent(Model model){
        model.addAttribute("student", iStudentService.findAllStudent());
        return "/admin/student";
    }


}
