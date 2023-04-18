package com.codegym.register_course.repository;

import com.codegym.register_course.model.Lecturer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;


public interface ILecturerRepository extends JpaRepository<Lecturer,Integer> {
    Page<Lecturer> findAllByLecturerNameContaining(String lecturerName, Pageable pageable);
    Page<Lecturer> findAll(Pageable pageable);
}
