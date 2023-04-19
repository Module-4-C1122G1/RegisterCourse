package com.codegym.register_course.service;

import com.codegym.register_course.model.CourseContent;
import com.codegym.register_course.model.CourseReview;

import java.util.List;

public interface IReviewService {
    List<CourseReview> fillAll();
}
