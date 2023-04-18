package com.codegym.register_course.controller;


import com.codegym.register_course.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;

import java.security.Principal;

@Controller
public class MainController {
    @GetMapping("/login")
    public String loginPage(Model model) {
        return "/login";
    }

    @GetMapping("/index")
    public String getPageWelcome(Model model, HttpServletRequest request) {
        model.addAttribute("request", request);
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
    public String getPageAbout() {
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
    public String getPageCourse() {
        return "/course";
    }

    @GetMapping("/teacher")
    public String getPageTeacher() {
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
}

