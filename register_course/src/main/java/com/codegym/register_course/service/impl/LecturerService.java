package com.codegym.register_course.service.impl;

import com.codegym.register_course.model.Lecturer;
import com.codegym.register_course.repository.ILecturerRepository;
import com.codegym.register_course.service.ILecturerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerService implements ILecturerService {
    private final ILecturerRepository iLecturerRepository;

    public LecturerService(ILecturerRepository iLecturerRepository) {
        this.iLecturerRepository = iLecturerRepository;
    }

    @Override
    public Page<Lecturer> findAll(String name, PageRequest pageRequest) {
        return iLecturerRepository.findAllByLecturerNameContaining(name, pageRequest);
    }

    @Override
    public List<Lecturer> findAllLecturer() {
        return iLecturerRepository.findAll();
    }

    @Override
    public void save(Lecturer lecturer) {
        iLecturerRepository.save(lecturer);
    }

    @Override
    public void update(Lecturer lecturer) {
        iLecturerRepository.save(lecturer);
    }

    @Override
    public Optional<Lecturer> findById(Integer lecturerID) {
        return iLecturerRepository.findById(lecturerID);
    }

    @Override
    public void removeById(Integer lecturerID) {
        iLecturerRepository.deleteById(lecturerID);
    }
}
