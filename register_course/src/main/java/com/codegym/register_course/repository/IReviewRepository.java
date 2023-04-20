package com.codegym.register_course.repository;

import com.codegym.register_course.model.CourseReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReviewRepository extends JpaRepository<CourseReview,Integer> {
}
