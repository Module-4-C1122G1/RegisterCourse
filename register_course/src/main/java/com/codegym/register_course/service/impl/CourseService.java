package com.codegym.register_course.service.impl;

import com.codegym.register_course.model.Course;
import com.codegym.register_course.repository.ICourseRepository;
import com.codegym.register_course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseService implements ICourseService {
    private final ICourseRepository repository;

    public CourseService(ICourseRepository repository) {
        this.repository = repository;
    }

//    @Override
//    public Page<Course> findAllByName(String nameSearch, Pageable pageable) {
//        return this.repository.findAllByCourseNameContaining(nameSearch,pageable);
//    }

//    @Override
//    public Page<Course> findAllCourse(Pageable pageable) {
//        return null;
//    }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public Course update(Integer courseID, Course course) {
        return repository.save(course);
    }

    @Override
    public void delete(Integer courseID, Course course) {
        repository.delete(course);
    }

    @Override
    public Course save(Course course) {
        return repository.save(course);
    }

    @Override
    public Optional<Course> findById(Integer courseID) {
        return Optional.empty();
    }

    @Override
    public Course getByID(Integer courseID) {
        return repository.findById(courseID).get();
    }
}
