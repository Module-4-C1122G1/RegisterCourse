package com.codegym.register_course.controller;

import com.codegym.register_course.model.Enrollment;
import com.codegym.register_course.service.IEnrollmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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

    @GetMapping("/create")
    public String showPageCreate(Model model) {
        model.addAttribute("enrollment", new Enrollment());
        return "/admin/enrollments/create";
    }

    @PostMapping("/create")
    public String createStudent(@Valid @ModelAttribute("enrollment") Enrollment enrollment,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        if (bindingResult.hasErrors()) {
            return "/admin/enrollments/create";
        } else {
            model.addAttribute("enrollment", service.save(enrollment));
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
            return "redirect:/admin/student";
        }
    }

    @GetMapping("update/{enrollmentID}")
    public String showPageUpdate(@PathVariable Integer enrollmentID, Model model) {
        model.addAttribute("enrollment", service.findById(enrollmentID));
        return "/admin/enrollments/update";
    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute("enrollment") Enrollment enrollment, BindingResult bindingResult,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/admin/enrollments/update";
        } else {
            model.addAttribute("enrollment",service.save(enrollment));
            redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
            return "redirect:/admin/enrollment";
        }
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Integer enrollmentID) {
        service.delete(enrollmentID, service.getEnrollmentByID(enrollmentID));
        return "redirect:/admin/enrollment";
    }
}
