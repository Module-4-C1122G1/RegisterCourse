package com.codegym.register_course.service;

import com.codegym.register_course.model.Employee;
import com.codegym.register_course.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAllByName(String nameSearch, Pageable pageable);

    List<Employee> findAllEmployee();

    void save(Employee employee);

    void update(Employee employee);

    Optional<Employee> findById(Integer employeeID);

    void delete (Integer employeeID, Employee employee);
    Page<Employee> findAll(Pageable pageable);
    Employee getEmployeeByID(Integer employeeID);
}
