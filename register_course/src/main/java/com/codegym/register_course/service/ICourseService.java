package com.codegym.register_course.service;

import com.codegym.register_course.model.Course;
import com.codegym.register_course.model.Curriculum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
//    Page<Course> findAllByName(String nameSearch, Pageable pageable);

//    Page<Course> findAllCourse(Pageable pageable);

    List<Course> findAll();

    Course update(Integer courseID, Course course);

    void delete(Integer courseID, Course course);

    Course save(Course course);

    Optional<Course> findById(Integer courseID);

    Course getByID(Integer courseID);
}
