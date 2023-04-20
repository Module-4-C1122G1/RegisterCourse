package com.codegym.register_course.service.impl;

import com.codegym.register_course.model.Enrollment;
import com.codegym.register_course.model.Student;
import com.codegym.register_course.repository.IEnrollmentRepository;
import com.codegym.register_course.service.IEnrollmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService implements IEnrollmentService {
    private final IEnrollmentRepository repository;

    public EnrollmentService(IEnrollmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Enrollment> findAll(String name, PageRequest pageRequest) {
        return repository.findAllByEnrollmentIDContaining(name,pageRequest);
    }

    @Override
    public List<Enrollment> findAllEnrollment() {
        return repository.findAll();
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return repository.save(enrollment);
    }

    @Override
    public void update(Enrollment enrollment) {
        repository.save(enrollment);
    }

    @Override
    public Optional<Enrollment> findById(Integer enrollmentID) {
        return this.repository.findById(enrollmentID);
    }

    @Override
    public void delete(Integer enrollmentID, Enrollment enrollment) {
        repository.delete(enrollment);
    }

    @Override
    public Enrollment getEnrollmentByID(Integer enrollmentID) {
        return repository.findById(enrollmentID).get();
    }

    @Override
    public boolean existsByPersonEmail(String personEmail) {
        return repository.existsByPersonEmail(personEmail);
    }

    @Override
    public boolean existsByPersonPhone(String personPhone) {
        return repository.existsByPersonPhone(personPhone);
    }
}
