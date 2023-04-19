package com.codegym.register_course.repository;

import com.codegym.register_course.model.CourseContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContentRepository extends JpaRepository<CourseContent,Integer> {
}
