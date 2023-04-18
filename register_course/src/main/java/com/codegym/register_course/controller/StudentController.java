package com.codegym.register_course.controller;

import com.codegym.register_course.model.Student;
import com.codegym.register_course.service.IStudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin/student")
public class StudentController {
    private final IStudentService iStudentService;

    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @GetMapping("")
    public String listStudent(Model model, @RequestParam(defaultValue = "", required = false) String searchName,
                              @PageableDefault(size = 5) Pageable pageable) {
        Page<Student> studentPage = null;
        model.addAttribute("searchName", searchName);
        model.addAttribute("total",iStudentService.findAllStudent());
        if (searchName != null) {
            studentPage = iStudentService.findAllByName(searchName, pageable);
        } else {
            studentPage = iStudentService.findAll(pageable);
        }
        model.addAttribute("student", studentPage);
        model.addAttribute("pageNumberList", IntStream.rangeClosed(1, studentPage.getTotalPages()).toArray());
        model.addAttribute("pageNumber", pageable.getPageNumber());
        model.addAttribute("nameSearch", searchName);
        model.addAttribute("pageSize", pageable.getPageSize());
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
    public String updateStudent(Model model, Student student,
                                RedirectAttributes redirectAttributes) {
        model.addAttribute("student", iStudentService.save(student));
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/admin/student";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Integer studentID) {
        iStudentService.delete(studentID, iStudentService.getStudentByID(studentID));
        return "redirect:/admin/student";
    }
}
