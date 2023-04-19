package com.codegym.register_course.controller;

import com.codegym.register_course.model.Course;
import com.codegym.register_course.model.Enrollment;
import com.codegym.register_course.model.Student;
import com.codegym.register_course.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/enrollment")
public class EnrollmentController {
    private final IEnrollmentService service;

    public EnrollmentController(IEnrollmentService service) {
        this.service = service;
    }

    @GetMapping("")
    public String showEnrollments(Model model) {
        model.addAttribute("enrollments", service.findAllEnrollment());
        return "/admin/enrollments/list";
    }
}
