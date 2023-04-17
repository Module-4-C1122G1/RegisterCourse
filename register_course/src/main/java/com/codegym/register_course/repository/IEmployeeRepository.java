package com.codegym.register_course.repository;

import com.codegym.register_course.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
}
