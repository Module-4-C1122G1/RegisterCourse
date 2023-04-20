package com.codegym.register_course.controller;

import com.codegym.register_course.model.Employee;
import com.codegym.register_course.service.IEmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@Controller()
@RequestMapping("/admin")
public class EmployeeController {
    private final IEmployeeService service;

    public EmployeeController(IEmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employee")
    public String showList(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam(defaultValue = "") String name) {
        Pageable sortedPage = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<Employee> employeePage = service.findAll(name, (PageRequest) sortedPage);
        model.addAttribute("total", service.findAllEmployee());
        model.addAttribute("employee", employeePage);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= employeePage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "/admin/employee/list";
    }

    @GetMapping("/employee/create")
    public String showCreate(Model model) {
        model.addAttribute("employeeCreate", new Employee());
        return "/admin/employee/create";
    }

    @PostMapping("/employee/create")
    public String create(Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "/admin/employee/create";
        }else {
            service.save(employee);
            return "redirect:/admin/employee";
        }
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
    @GetMapping("/employee/delete")
    public String deleteStudent(@RequestParam Integer employeeID) {
        service.delete(employeeID, service.getEmployeeByID(employeeID));
        return "redirect:/admin/employee";
    }
}
