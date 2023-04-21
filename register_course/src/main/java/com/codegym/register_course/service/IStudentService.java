package com.codegym.register_course.service;

import com.codegym.register_course.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> findAllStudent();

    void save(Student student);

    void update(Student student);

    Optional<Student> findById(Integer studentID);

    void delete(Integer studentID, Student student);
    Student getStudentByID(Integer studentID);
    @Transactional
    void deleteAllStudent(Integer studentID);
    Page<Student> findAll(String name, PageRequest pageRequest);
    boolean existsByStudentEmail(String studentEmail);
    boolean existsByStudentPhone(String studentPhone);
}