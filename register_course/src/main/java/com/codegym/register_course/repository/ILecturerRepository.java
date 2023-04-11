package com.codegym.register_course.repository;

import com.codegym.register_course.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILecturerRepository extends JpaRepository<Lecturer,Integer> {
}
