package com.codegym.register_course.controller;

import com.codegym.register_course.model.Course;
import com.codegym.register_course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class CourseController {
    private final ICourseService courseServiceAdmin;

    public CourseController(ICourseService courseServiceAdmin) {
        this.courseServiceAdmin = courseServiceAdmin;
    }


    @GetMapping("/course")
    public String showList(Model model){
        model.addAttribute("courseAdmin", courseServiceAdmin.findAll());
        return "admin/course/list";
    }
    @GetMapping("/course/create")
    public String showCreate(Model model){
        model.addAttribute("courseCreate", new Course());
        return "/admin/course/create";
    }
    @PostMapping("/course/create")
    public String create(Course course){
        courseServiceAdmin.save(course);
        return "redirect:/admin/course";
    }

}
