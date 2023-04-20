package com.codegym.register_course.service.impl;

import com.codegym.register_course.model.Curriculum;
import com.codegym.register_course.repository.ICurriculumRepository;
import com.codegym.register_course.service.ICurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculumService implements ICurriculumService {
    @Autowired
    private ICurriculumRepository curriculumRepository;

    @Override
    public Page<Curriculum> findAll(String name, PageRequest pageRequest) {
        return this.curriculumRepository.findAllByCurriculumNameContaining(name, pageRequest);
    }

    @Override
    public Page<Curriculum> findAllByNameAndStatus(String name, Integer statusId, PageRequest pageRequest) {
        return this.curriculumRepository.findAllByNameContainingAndStatus(name, statusId, pageRequest);
    }

    @Override
    public List<Curriculum> findAllCurriculum() {
        return curriculumRepository.findAll();
    }

    @Override
    public Curriculum update(Integer curriculumID, Curriculum curriculum) {
        return this.curriculumRepository.save(curriculum);
    }

    @Override
    public void delete(Integer curriculumID, Curriculum curriculum) {
        this.curriculumRepository.delete(curriculum);

    }

    @Override
    public Curriculum save(Curriculum curriculum) {
        return this.curriculumRepository.save(curriculum);
    }

    @Override
    public Optional<Curriculum> findById(Integer curriculumID) {
        return this.curriculumRepository.findById(curriculumID);
    }

    @Override
    public Curriculum getByID(Integer curriculumID) {
        return this.curriculumRepository.findById(curriculumID).get();
    }

}
