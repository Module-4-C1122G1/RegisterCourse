package com.codegym.register_course.service.impl;

import com.codegym.register_course.model.Curriculum;
import com.codegym.register_course.repository.ICurriculumRepository;
import com.codegym.register_course.service.ICurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculumService implements ICurriculumService {
    @Autowired
    private ICurriculumRepository curriculumRepository;

    @Override
    public Page<Curriculum> findAllByName(String nameSearch, Pageable pageable) {
        return this.curriculumRepository.findAllByCurriculumNameContaining(nameSearch, pageable);
    }

    @Override
    public List<Curriculum> findAllCurriculum() {
        return this.curriculumRepository.findAll();
    }

    @Override
    public void update(Integer id, Curriculum curriculum) {
        this.curriculumRepository.save(curriculum);
    }

    @Override
    public void delete(Curriculum curriculum) {
        this.curriculumRepository.delete(curriculum);
    }

    @Override
    public void save(Curriculum curriculum) {
        this.curriculumRepository.save(curriculum);
    }

    @Override
    public Optional<Curriculum> findById(Integer id) {
        return this.curriculumRepository.findById(id);
    }
}
