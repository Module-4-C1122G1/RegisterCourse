package com.codegym.register_course.repository;

import com.codegym.register_course.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    void deleteStudentByStudentID(Integer studentID);

//    Page<Student> findAllByStudentNameContaining(String name, PageRequest pageRequest);

    Page<Student> findAll(Pageable pageable);

    void deleteAllByStudentID(Integer studentID);
    boolean existsByStudentEmail(String studentEmail);
    boolean existsByStudentPhone(String studentPhone);
    @Query(value = "select * from student where flag = 0", nativeQuery = true)
    Page<Student> findAllByStudentNameContaining(String name, PageRequest pageRequest);
    @Query(value = "select * from student where flag = 0", nativeQuery = true)
    List<Student> findAllStudent();
}
