package com.codegym.register_course.service;

import com.codegym.register_course.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(String name, PageRequest pageRequest);

    List<Employee> findAllEmployee();

    void save(Employee employee);

    void update(Employee employee);

    Optional<Employee> findById(Integer employeeID);

    void delete (Integer employeeID, Employee employee);
    Employee getEmployeeByID(Integer employeeID);
}
