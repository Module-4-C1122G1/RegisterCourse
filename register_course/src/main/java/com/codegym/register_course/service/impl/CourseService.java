package com.codegym.register_course.service.impl;

import com.codegym.register_course.model.Course;
import com.codegym.register_course.model.Employee;
import com.codegym.register_course.model.Lecturer;
import com.codegym.register_course.repository.ICourseRepository;
import com.codegym.register_course.repository.IEmployeeRepository;
import com.codegym.register_course.repository.ILecturerRepository;
import com.codegym.register_course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseService implements ICourseService {
    private final ICourseRepository repositoryCourse;
    private final IEmployeeRepository employeeRepository;
    private final ILecturerRepository lecturerRepository;

    public CourseService(ICourseRepository repositoryCourse, IEmployeeRepository employeeRepository, ILecturerRepository lecturerRepository) {
        this.repositoryCourse = repositoryCourse;
        this.employeeRepository = employeeRepository;
        this.lecturerRepository = lecturerRepository;
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
        return repositoryCourse.findAll();
    }

    @Override
    public Course update(Integer courseID, Course course) {
        return repositoryCourse.save(course);
    }

    @Override
    public void delete(Integer courseID, Course course) {
        repositoryCourse.delete(course);
    }

    @Override
    public void save(Course course) {
        Employee employee =employeeRepository.findById(course.getEmployee().getEmployeeID()).get();
        course.setEmployee(employee);
        Lecturer lecturer = lecturerRepository.findById(course.getLecturer().getLecturerID()).get();
        course.setLecturer(lecturer);
        repositoryCourse.save(course);
    }

    @Override
    public Optional<Course> findById(Integer courseID) {
        return Optional.empty();
    }

    @Override
    public Course getByID(Integer courseID) {
        return repositoryCourse.findById(courseID).get();
    }
}
