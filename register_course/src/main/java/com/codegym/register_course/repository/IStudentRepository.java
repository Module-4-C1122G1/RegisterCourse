package com.codegym.register_course.repository;

import com.codegym.register_course.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
    void deleteStudentByStudentID(Integer studentID);
    Page<Student> findAllByStudentNameContaining(String studentName, Pageable pageable);
    Page<Student> findAll(Pageable pageable);

}
