package com.codegym.register_course.service;

import com.codegym.register_course.model.Curriculum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICurriculumService {
    Page<Curriculum> findAllByName(String nameSearch, Pageable pageable);

    List<Curriculum> findAllCurriculum();

    void update(Integer id, Curriculum curriculum);

    void delete(Curriculum curriculum);

    void save(Curriculum curriculum);

    Optional<Curriculum> findById(Integer id);
}
