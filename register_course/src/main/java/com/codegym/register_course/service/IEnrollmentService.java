package com.codegym.register_course.service;

import com.codegym.register_course.model.Enrollment;

import java.util.List;

public interface IEnrollmentService {
    List<Enrollment> findAllEnrollment();
}
