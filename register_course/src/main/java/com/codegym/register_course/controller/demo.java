package com.codegym.register_course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class demo {
    @GetMapping()
    public String list(){
        return "/admin/lecturer";
    }
}
