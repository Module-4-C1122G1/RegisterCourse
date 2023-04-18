package com.codegym.register_course.service;

import com.codegym.register_course.model.Lecturer;
import com.codegym.register_course.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ILecturerService {
    Page<Lecturer> findAllByName(String nameSearch, Pageable pageable);

    List<Lecturer> findAllLecturer();

    void save(Lecturer lecturer);

    void update(Lecturer lecturer);

    Optional<Lecturer> findById(Integer lecturerID);

    void removeById(Integer lecturerID);
    Page<Lecturer> findAll(Pageable pageable);

}
