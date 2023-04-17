package com.codegym.register_course.controller;

import com.codegym.register_course.model.Employee;
import com.codegym.register_course.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/admin")
public class EmployeeController {
    private final IEmployeeService service;

    public EmployeeController(IEmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employee")
    public String showList(Model model) {
        model.addAttribute("employee", service.findAllEmployee());
        return "/admin/employee/list";
    }

    @GetMapping("/employee/create")
    public String showCreate(Model model) {
        model.addAttribute("employeeCreate", new Employee());
        return "/admin/employee/create";
    }

    @PostMapping("/employee/create")
    public String create(Employee employee) {
        service.save(employee);
        return "redirect:/admin/employee";
    }

    @GetMapping("/employee/edit/{id}")
    public String showEdit(
            Model model,
            @PathVariable("id") Integer id
            )
    {
        model.addAttribute("employeeEdit", service.findById(id));
        return "/admin/employee/edit";

    }

    @PostMapping("/employee/edit")
    public String edit(Employee employee){
        service.update(employee);
        return "redirect:/admin/employee";
    }
}
