package com.codegym.register_course.controller;

import com.codegym.register_course.model.Lecturer;
import com.codegym.register_course.service.ILecturerService;
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
@RequestMapping("/admin")
public class LecturerController {
    private final ILecturerService service;

    public LecturerController(ILecturerService service) {
        this.service = service;
    }


    @GetMapping("/lecturer")
    public String showListAdmin(
            Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam(defaultValue = "") String name) {
        Pageable sortedPage = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<Lecturer> lecturerPage = service.findAll(name, (PageRequest) sortedPage);
        model.addAttribute("total", service.findAllLecturer());
        model.addAttribute("lecturer", lecturerPage);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= lecturerPage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
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
    public String delete (@RequestParam Integer lecturerID,RedirectAttributes redirectAttributes) {
        service.removeById(lecturerID);
        redirectAttributes.addFlashAttribute("msg","Xóa thành công");
        return "redirect:/admin/lecturer";
    }

}
