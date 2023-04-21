package com.codegym.register_course.controller;

import com.codegym.register_course.model.Course;
import com.codegym.register_course.model.Student;
import com.codegym.register_course.service.IStudentService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/student")
public class StudentController {
    private final IStudentService iStudentService;

    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @GetMapping("")
    public String listStudent(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam(defaultValue = "") String name) {
        Pageable sortedPage = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<Student> studentPage = iStudentService.findAll(name, (PageRequest) sortedPage);
        model.addAttribute("total", iStudentService.findAllStudent());
        model.addAttribute("student", studentPage);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= studentPage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("nameValue", name);
        model.addAttribute("pageNumberList", pageNumberList);
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
        }else if (iStudentService.existsByStudentEmail(student.getStudentEmail())) {
            model.addAttribute("message1", "Email đã tồn tại, vui lòng nhập email khác");
            return "/admin/student/create-student";
        } else if (iStudentService.existsByStudentPhone(student.getStudentPhone())) {
           model.addAttribute("message2", "Số điện thoại đã tồn tại, vui lòng nhập số điện thoại khác");
            return "/admin/student/create-student";
        }else {
            student.setFlag(0);
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
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/admin/student/update-student";
        } else {
            model.addAttribute("student", iStudentService.save(student));
            redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
            return "redirect:/admin/student";
        }
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Integer studentID, Student student1) {
        student1 = iStudentService.getStudentByID(studentID);
        student1.setFlag(1);
        iStudentService.save(student1);
        return "redirect:/admin/student";
    }
    @GetMapping("/detail")
    public String detailStudent(Model model, @RequestParam Integer studentID){
        model.addAttribute("student", iStudentService.getStudentByID(studentID));
        return "redirect:/admin/student";
    }
}
