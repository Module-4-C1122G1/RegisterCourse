package com.codegym.register_course.service.impl;

import com.codegym.register_course.model.Student;
import com.codegym.register_course.repository.IStudentRepository;
import com.codegym.register_course.service.IStudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    private final IStudentRepository iStudentRepository;

    public StudentService(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    @Override
    public Page<Student> findAll(String studentName, Pageable pageable) {
        return iStudentRepository.findAll(pageable);
    }

    @Override
    public List<Student> findAllStudent() {
        return iStudentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return iStudentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Integer studentID) {
        return iStudentRepository.findById(studentID);
    }

    @Override
    public void delete(Integer studentID, Student student) {
        this.iStudentRepository.delete(student);
    }

    @Override
    public Student getStudentByID(Integer studentID) {
        return iStudentRepository.findById(studentID).get();
    }
}
