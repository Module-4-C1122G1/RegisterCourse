package com.codegym.register_course.service.impl;

import com.codegym.register_course.model.CourseContent;
import com.codegym.register_course.repository.IContentRepository;
import com.codegym.register_course.service.IContentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService implements IContentService {
    public final IContentRepository repository;

    public ContentService(IContentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CourseContent> findAll() {
        return repository.findAll();
    }
}
