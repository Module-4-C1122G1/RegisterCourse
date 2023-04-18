package com.codegym.register_course.service;

import com.codegym.register_course.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Page<Student> findAll(String studentName, Pageable pageable);

    List<Student> findAllStudent();

    Student save(Student student);

    void update(Student student);

    Optional<Student> findById(Integer studentID);

    void delete(Integer studentID, Student student);
    Student getStudentByID(Integer studentID);
    void deleteAllStudent(Integer studentID);
    Page<Student> findAll(PageRequest pageRequest);
}
