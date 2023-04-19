package com.codegym.register_course.controller;

import com.codegym.register_course.model.Curriculum;
import com.codegym.register_course.repository.ICurriculumStatusRepository;
import com.codegym.register_course.service.ICurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin/curriculum")
public class CurriculumController {
    @Autowired
    private ICurriculumService curriculumService;

    @Autowired
    private ICurriculumStatusRepository curriculumStatusRepository;

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Integer curriculumID) {
        curriculumService.delete(curriculumID, curriculumService.getByID(curriculumID));
        return "redirect:/admin/curriculum";
    }

    @GetMapping("/status")
    public String getStatus(Model model) {
        model.addAttribute("listStatus", curriculumStatusRepository.findAll());
        return "admin/curriculum/curriculum";
    }

    @GetMapping("")
    public String findAll(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam(defaultValue = "") String name) {
        Pageable sortedPage = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<Curriculum> curriculumPage = curriculumService.findAll(name, (PageRequest) sortedPage);
        model.addAttribute("total", curriculumService.findAllCurriculum());
        model.addAttribute("curriculum", curriculumPage);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= curriculumPage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "admin/curriculum/curriculum";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("curriculumCreate", new Curriculum());
        model.addAttribute("listStatus", curriculumStatusRepository.findAll());
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
            model.addAttribute("listStatus", curriculumStatusRepository.findAll());
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
            model.addAttribute("listStatus", curriculumStatusRepository.findAll());
            model.addAttribute("curriculumEdit", curriculumService.save(curriculum));
            redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
            return "redirect:/admin/curriculum";
        }
    }
}
