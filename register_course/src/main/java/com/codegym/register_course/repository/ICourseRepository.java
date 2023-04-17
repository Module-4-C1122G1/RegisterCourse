package com.codegym.register_course.repository;

import com.codegym.register_course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course,Integer> {
}
