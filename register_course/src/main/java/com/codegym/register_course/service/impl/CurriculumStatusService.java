package com.codegym.register_course.service.impl;

import com.codegym.register_course.model.CurriculumStatus;
import com.codegym.register_course.repository.ICurriculumStatusRepository;
import com.codegym.register_course.service.ICurriculumStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumStatusService implements ICurriculumStatusService {
    @Autowired
    private ICurriculumStatusRepository curriculumStatusRepository;

    @Override
    public List<CurriculumStatus> findAll() {
        return this.curriculumStatusRepository.findAll();
    }
}