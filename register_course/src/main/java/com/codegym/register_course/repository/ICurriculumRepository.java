package com.codegym.register_course.repository;

import com.codegym.register_course.model.Curriculum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICurriculumRepository extends JpaRepository<Curriculum, Integer> {
    Page<Curriculum> findAllByCurriculumNameContaining(String name, Pageable pageable);
    Page<Curriculum> findAll(Pageable pageable);

    Curriculum findAllByCurriculumName(String name);
}
