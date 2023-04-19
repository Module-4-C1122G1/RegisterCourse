package com.codegym.register_course.service;

import com.codegym.register_course.model.Employee;
import com.codegym.register_course.model.Enrollment;
import com.codegym.register_course.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface IEnrollmentService {
    List<Enrollment> findAllEnrollment();
    Page<Enrollment> findAll(String name, PageRequest pageRequest);

    Enrollment save(Enrollment enrollment);

    void update(Enrollment enrollment);

    Optional<Enrollment> findById(Integer enrollmentID);

    void delete (Integer enrollmentID, Enrollment enrollment);
    Enrollment getEnrollmentByID(Integer enrollmentID);
}
