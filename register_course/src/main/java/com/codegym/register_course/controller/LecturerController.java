package com.codegym.register_course.controller;

import com.codegym.register_course.model.Lecturer;
import com.codegym.register_course.service.ILecturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
public class LecturerController {
    private final ILecturerService service;

    public LecturerController(ILecturerService service) {
        this.service = service;
    }

    @GetMapping("/teacher")
    public String showList(
            Model model
    ){
        model.addAttribute("lecturer", service.findAllLecturer());
        return "/teacher";
    }
    @GetMapping("/lecturer")
    public String showListAdmin(
            Model model
    ){
        model.addAttribute("lecturer1", service.findAllLecturer());
        return "/admin/lecturer/list";
    }

    @GetMapping("/lecturer/create")
    public String showCreate(
            Model model
    ){
        model.addAttribute("lecturerCreate", new Lecturer());
        return "/admin/lecturer/create";
    }

    @PostMapping("/lecturer/create")
    public String createLecturer(@Valid @ModelAttribute("lecturerCreate") Lecturer lecturer,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model
            ){
        if (bindingResult.hasErrors()){
            return "/admin/lecturer/create";
        }else {
        service.save(lecturer);
        redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        return "redirect:/admin/lecturer";
        }
    }

    @GetMapping("/lecturer/edit/{id}")
    public String showEdit(
            Model model,
            @PathVariable("id") Integer id
    ){
        model.addAttribute("lecturerEdit", service.findById(id));
        return "/admin/lecturer/edit";
    }

    @PostMapping("/lecturer/edit")
    public String edit(@Valid @ModelAttribute("lecturerEdit") Lecturer lecturer,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model){
        if(bindingResult.hasErrors()){
            return "/admin/lecturer/edit";
        }else {
        service.save(lecturer);
        redirectAttributes.addFlashAttribute("msg","Cập nhập thành công");
        return "redirect:/admin/lecturer";
        }
    }

    @GetMapping("/lecturer/delete")
    public String delete (@RequestParam Integer lecturerID) {
        service.removeById(lecturerID);
        return "redirect:/admin/lecturer";
    }
}
