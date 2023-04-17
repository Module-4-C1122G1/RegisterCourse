package com.codegym.register_course.controller;

import com.codegym.register_course.model.Employee;
import com.codegym.register_course.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/admin/employee")
public class EmployeeController {
    private final IEmployeeService service;

    public EmployeeController(IEmployeeService service) {
        this.service = service;
    }

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("employee", service.findAllEmployee());
        return "/admin/employee/list";
    }

    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("employeeCreate", new Employee());
        return "/admin/employee/create";
    }

    @PostMapping("create")
    public String create(Employee employee){
        service.save(employee);
        return "redirect:/admin/employee";
    }
}
