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
    public Page<Employee> findAllByName(String nameSearch, Pageable pageable) {
        return repository.findAllByEmployeeNameContaining(nameSearch,pageable);
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
        return this.repository.findById(employeeID);
    }

    @Override
    public void delete(Integer employeeID, Employee employee) {
        repository.delete(employee);
    }


    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Employee getEmployeeByID(Integer employeeID) {
        return repository.findById(employeeID).get();
    }
}
