package com.codegym.register_course.controller;

import com.codegym.register_course.model.Course;
import com.codegym.register_course.model.Lecturer;
import com.codegym.register_course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    public String create(@Valid @ModelAttribute("courseCreate") Course course,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        if (bindingResult.hasErrors()){
            return "/admin/course/create";
        }else {
            courseServiceAdmin.save(course);
            redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
            return "redirect:/admin/course";
        }
    }
}
