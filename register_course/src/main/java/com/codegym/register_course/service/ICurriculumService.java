package com.codegym.register_course.service;

import com.codegym.register_course.model.Curriculum;
import com.codegym.register_course.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICurriculumService {
    Page<Curriculum> findAll(String name, PageRequest pageRequest);


    List<Curriculum> findAllCurriculum();

    Curriculum update(Integer curriculumID, Curriculum curriculum);

    void delete(Integer curriculumID, Curriculum curriculum);

    Curriculum save(Curriculum curriculum);

    Optional<Curriculum> findById(Integer curriculumID);

    Curriculum getByID(Integer curriculumID);
}
