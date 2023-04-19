package com.codegym.register_course.controller;


import com.codegym.register_course.model.Course;
import com.codegym.register_course.service.IContentService;
import com.codegym.register_course.service.ICourseService;
import com.codegym.register_course.service.ILecturerService;
import com.codegym.register_course.service.IReviewService;
import com.codegym.register_course.utils.WebUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;

import java.security.Principal;

@Controller
public class MainController {
    private final IReviewService reviewService;
    private final IContentService contentService;
    private final ICourseService courseService;
    private final ILecturerService service;

    public MainController(ILecturerService service, ICourseService courseService, IContentService contentService, IReviewService reviewService) {
        this.service = service;
        this.courseService = courseService;
        this.contentService = contentService;
        this.reviewService = reviewService;
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "/login";
    }

    @GetMapping("/index")
    public String getPageWelcome(Model model, HttpServletRequest request) {
        model.addAttribute("request", request);
        model.addAttribute("contentList", contentService.findAll());
        model.addAttribute("courseList", courseService.findAll());
        model.addAttribute("teacherList", service.findAllLecturer());
        model.addAttribute("review", reviewService.fillAll());
        return "/index";
    }

    @GetMapping("/")
    public String getPageHome(Model model, HttpServletRequest request) {
        model.addAttribute("request", request);
        return "/index";
    }

    @GetMapping("/logout")
    public String logoutSuccessfulPage(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Đăng xuất thành công!");
        return "/login";
    }

    @GetMapping("/403")
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> Bạn không có quyền truy cập trang này!";
            model.addAttribute("message", message);

        }
        return "/403Page";
    }


    @GetMapping("/about")
    public String getPageAbout(Model model) {
        model.addAttribute("courseList", courseService.findAll());
        return "/about";
    }

    @GetMapping("/blog")
    public String getPageBlog() {
        return "/blog";
    }

    @GetMapping("/contact")
    public String getPageContact() {
        return "/contact";
    }

    @GetMapping("/course")
    public String getPageCourse(Model model) {
        model.addAttribute("courseList", courseService.findAll());
        return "/course";
    }

    @GetMapping("/teacher")
    public String getPageTeacher(Model model) {
        model.addAttribute("teacher", service.findAllLecturer());
        return "/teacher";
    }

    @GetMapping("/single")
    public String getPageSingle() {
        return "/single";
    }

    @GetMapping("/register")
    public String getPageRegister() {
        return "/register";
    }

    @GetMapping("/single/detail/{id}")
    public String showDetail(@PathVariable("id") Integer id,
                             Model model){
        model.addAttribute("single", courseService.getByID(id));
        return "/single";
    }
}

