package com.codegym.register_course.controller;

import com.codegym.register_course.service.IStudentService;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {
    private final IStudentService iStudentService;

    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

}
