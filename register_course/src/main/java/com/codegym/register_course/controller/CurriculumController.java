package com.codegym.register_course.controller;

import com.codegym.register_course.model.Curriculum;
import com.codegym.register_course.service.ICurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin/curriculum")
public class CurriculumController {
    @Autowired
    private ICurriculumService curriculumService;

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Integer curriculumID) {
        curriculumService.delete(curriculumID, curriculumService.getByID(curriculumID));
        return "redirect:/admin/curriculum";
    }

    @GetMapping("")
    public String findAll(Model model, @RequestParam(defaultValue = "", required = false) String searchName,
                          @PageableDefault(size = 5) Pageable pageable) {
        Page<Curriculum> curriculumPage = null;
        model.addAttribute("searchName", searchName);
        model.addAttribute("total", curriculumService.findAll());
        if (searchName != null) {
            curriculumPage = curriculumService.findAllByName(searchName, pageable);
        } else {
            curriculumPage = curriculumService.findAllCurriculum(pageable);
        }
        model.addAttribute("curriculum", curriculumPage);
        model.addAttribute("pageNumberList", IntStream.rangeClosed(1, curriculumPage.getTotalPages()).toArray());
        model.addAttribute("pageNumber", pageable.getPageNumber());
        model.addAttribute("nameSearch", searchName);
        model.addAttribute("pageSize", pageable.getPageSize());
        return "admin/curriculum/curriculum";
    }
    @GetMapping("/create")
    public String showCreate(
            Model model
    ) {
        model.addAttribute("curriculumCreate", new Curriculum());
        return "/admin/curriculum/create-curriculum";
    }

    @PostMapping("/create")
    public String createCurriculum(@Validated @ModelAttribute("curriculumCreate") Curriculum curriculum,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes,
                                   Model model) {
        if (bindingResult.hasErrors()) {
            return "/admin/curriculum/create-curriculum";
        } else {
            model.addAttribute("curriculumCreate", curriculumService.save(curriculum));
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
            return "redirect:/admin/curriculum";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEdit(
            Model model,
            @PathVariable("id") Integer id
    ) {
        model.addAttribute("curriculumEdit", curriculumService.findById(id));
        return "/admin/curriculum/edit-curriculum";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("curriculumEdit") Curriculum curriculum,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        if (bindingResult.hasErrors()) {
            return "/admin/curriculum/edit-curriculum";
        } else {
            model.addAttribute("curriculumEdit", curriculumService.save(curriculum));
            redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
            return "redirect:/admin/curriculum";
        }
    }
}
