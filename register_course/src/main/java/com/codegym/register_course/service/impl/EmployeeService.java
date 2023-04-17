package com.codegym.register_course.service.impl;

import com.codegym.register_course.model.Employee;
import com.codegym.register_course.repository.IEmployeeRepository;
import com.codegym.register_course.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository repository;

    public EmployeeService(IEmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Employee> findAll(String employeeName, Pageable pageable) {
        return null;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return repository.findAll();
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        repository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Integer employeeID) {
        return Optional.empty();
    }

    @Override
    public void removeById(Integer employeeID) {

    }
}
