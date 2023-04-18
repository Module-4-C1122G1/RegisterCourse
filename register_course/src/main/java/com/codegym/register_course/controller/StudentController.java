package com.codegym.register_course.controller;

import com.codegym.register_course.model.Student;
import com.codegym.register_course.service.IStudentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.ResultSet;

@Controller
@RequestMapping("/admin/student")
public class StudentController {
    private final IStudentService iStudentService;

    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @GetMapping("")
    public String listStudent(Model model) {
        model.addAttribute("student", iStudentService.findAllStudent());
        return "/admin/student/student";
    }

    @GetMapping("/create")
    public String showPageCreate(Model model) {
        model.addAttribute("student", new Student());
        return "/admin/student/create-student";
    }

    @PostMapping("/create")
    public String createStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        if (bindingResult.hasErrors()) {
            return "/admin/student/create-student";
        } else {
            model.addAttribute("student", iStudentService.save(student));
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
            return "redirect:/admin/student";
        }
    }

    @GetMapping("update/{studentID}")
    public String showPageUpdate(@PathVariable Integer studentID, Model model) {
        model.addAttribute("student", iStudentService.findById(studentID));
        return "/admin/student/update-student";
    }

    @PostMapping("/update")
    public String updateStudent(Model model, Student student) {
        model.addAttribute("student", iStudentService.save(student));
        String message = "Thêm mới thành công";
        return "redirect:/admin/student";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Integer studentID) {
        iStudentService.delete(studentID, iStudentService.getStudentByID(studentID));
        return "redirect:/admin/student";
    }

    @PostMapping("findStudentByName")
    public String findStudentByName(Model model, @RequestParam String studentName, Integer page) {
        Sort sort = Sort.by(studentName);
        model.addAttribute("student", iStudentService.findAll(studentName, PageRequest.of(page, 2, sort)));
        return "redirect:/admin/student";
    }
}
