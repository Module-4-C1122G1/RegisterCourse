package com.codegym.register_course.service;

import com.codegym.register_course.model.CourseContent;

import java.util.List;

public interface IContentService {
    List<CourseContent> findAll();
}
