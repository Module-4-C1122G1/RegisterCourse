package com.codegym.register_course.repository;

import com.codegym.register_course.model.CurriculumStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurriculumStatusRepository extends JpaRepository<CurriculumStatus, Integer> {
}