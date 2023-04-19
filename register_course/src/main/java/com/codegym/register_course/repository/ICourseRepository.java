package com.codegym.register_course.repository;

import com.codegym.register_course.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public interface ICourseRepository extends JpaRepository<Course,Integer> {

}
