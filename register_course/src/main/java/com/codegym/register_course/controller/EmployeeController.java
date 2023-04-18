package com.codegym.register_course.controller;

import com.codegym.register_course.model.Employee;
import com.codegym.register_course.service.IEmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;

@Controller()
@RequestMapping("/admin")
public class EmployeeController {
    private final IEmployeeService service;

    public EmployeeController(IEmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employee")
    public String showList(Model model, @RequestParam(defaultValue = "", required = false) String searchName,
                           @PageableDefault(size = 5) Pageable pageable) {
        Page<Employee> employeePage = null;
        model.addAttribute("searchName", searchName);
        model.addAttribute("total",service.findAllEmployee());
        Sort sort = Sort.by("employee_id").descending();
        if (searchName != null) {
            employeePage = service.findAllByName(searchName, pageable);
        } else {
            employeePage = service.findAll(pageable);
        }
        model.addAttribute("employee", employeePage);
        model.addAttribute("pageNumberList", IntStream.rangeClosed(1, employeePage.getTotalPages()).toArray());
        model.addAttribute("pageNumber", pageable.getPageNumber());
        model.addAttribute("nameSearch", searchName);
        model.addAttribute("pageSize", pageable.getPageSize());
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
    @GetMapping("/employee/delete")
    public String deleteStudent(@RequestParam Integer employeeID) {
        service.delete(employeeID, service.getEmployeeByID(employeeID));
        return "redirect:/admin/employee";
    }
}
