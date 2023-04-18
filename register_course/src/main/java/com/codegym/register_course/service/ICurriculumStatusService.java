package com.codegym.register_course.service;

import com.codegym.register_course.model.CurriculumStatus;

import java.util.List;

public interface ICurriculumStatusService{
    List<CurriculumStatus> findAll();
}
