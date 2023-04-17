package com.codegym.register_course.controller;

import com.codegym.register_course.model.Lecturer;
import com.codegym.register_course.service.ILecturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String createLecturer(Lecturer lecturer){
        service.save(lecturer);
        return "redirect:/admin/lecturer";
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
    public String edit(Lecturer lecturer){
        service.save(lecturer);
        return "redirect:/admin/lecturer";
    }

    @GetMapping("/lecturer/delete")
    public String delete (@PathVariable Integer deleteId) {
        service.removeById(deleteId);
        return "redirect:/admin/lecturer";
    }
}
