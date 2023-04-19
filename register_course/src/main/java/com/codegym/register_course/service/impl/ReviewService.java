package com.codegym.register_course.service.impl;

import com.codegym.register_course.model.CourseReview;
import com.codegym.register_course.repository.IReviewRepository;
import com.codegym.register_course.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewService implements IReviewService {
    private final IReviewRepository repository;

    public ReviewService(IReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CourseReview> fillAll() {
        return repository.findAll();
    }
}
