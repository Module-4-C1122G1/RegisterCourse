package com.codegym.register_course.service.impl;

import com.codegym.register_course.model.Enrollment;
import com.codegym.register_course.repository.IEnrollmentRepository;
import com.codegym.register_course.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService implements IEnrollmentService {
    private final IEnrollmentRepository repository;

    public EnrollmentService(IEnrollmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Enrollment> findAllEnrollment() {
        return repository.findAll();
    }
}
