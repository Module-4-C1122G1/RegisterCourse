package com.codegym.register_course.controller;

import com.codegym.register_course.DTO.EnrollmentDTO;
import com.codegym.register_course.model.Enrollment;
import com.codegym.register_course.service.IEnrollmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.time.LocalDate;



@Controller
public class EnrollmentController {
    private final IEnrollmentService service;

    public EnrollmentController(IEnrollmentService service) {
        this.service = service;
    }

    @GetMapping("/admin/enrollment")
    public String showEnrollments(Model model) {
        model.addAttribute("enrollments", service.findAllEnrollment());
        return "/admin/enrollments/list";
    }

    @PostMapping("enrollment/create")
    public String createStudent(@Valid @ModelAttribute("enrollmentDTO") EnrollmentDTO enrollmentDTO,
                                @RequestParam(name = "courseName") String courseName,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/index";
        } else if (service.existsByPersonPhone(enrollmentDTO.getPersonPhone())) {
            redirectAttributes.addFlashAttribute("message1", "Số điện thoại đã đăng ký, vui lòng nhập số khác");
            return "redirect:/index";
        } else if (service.existsByPersonEmail(enrollmentDTO.getPersonEmail())) {
            redirectAttributes.addFlashAttribute("message2","Email đã tồn tại, vui lòng nhập email khác");
            return "redirect:/index";
        } else {
            Enrollment enrollment = new Enrollment();
            BeanUtils.copyProperties(enrollmentDTO, enrollment);
            model.addAttribute("enrollment", service.save(enrollment));
            enrollment.setEnrollmentStatus("Đang chờ");
            enrollment.setCourseName(courseName);
            String date = String.valueOf(LocalDate.now());
            enrollment.setEnrollmentDate(date);
            service.save(enrollment);
            redirectAttributes.addFlashAttribute("message", "Đăng ký thành công");
            return "redirect:/index";
        }
    }

    @GetMapping("/admin/enrollment/update/{enrollmentID}")
    public String showPageUpdate(@PathVariable Integer enrollmentID, Model model) {
        model.addAttribute("enrollment", service.findById(enrollmentID));
        return "/admin/enrollments/update";
    }

    @PostMapping("/admin/enrollment/update")
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

    @GetMapping("/admin/enrollment/delete")
    public String deleteStudent(@RequestParam Integer enrollmentID) {
        service.delete(enrollmentID, service.getEnrollmentByID(enrollmentID));
        return "redirect:/admin/enrollment";
    }
}