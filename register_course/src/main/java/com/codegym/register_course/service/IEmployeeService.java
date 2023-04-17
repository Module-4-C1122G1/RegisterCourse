package com.codegym.register_course.service;

import com.codegym.register_course.model.Employee;
import com.codegym.register_course.model.Lecturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(String employeeName, Pageable pageable);

    List<Employee> findAllEmployee();

    void save(Employee employee);

    void update(Employee employee);

    Optional<Employee> findById(Integer employeeID);

    void removeById(Integer employeeID);
}
