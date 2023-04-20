package com.codegym.register_course.repository;

import com.codegym.register_course.model.Curriculum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICurriculumRepository extends JpaRepository<Curriculum, Integer> {
    Page<Curriculum> findAllByCurriculumNameContaining(String name, PageRequest pageRequest);

    Page<Curriculum> findAll(Pageable pageable);

    Curriculum findAllByCurriculumName(String name);

    @Query(value = "select * from curriculum where curriculum_name like concat('%',:name,'%') and (:statusId = '0' or curriculum_status_id = :statusId)", nativeQuery = true)
    Page<Curriculum> findAllByNameContainingAndStatus(@Param("name") String name,
                                                                               @Param("statusId") Integer statusId,
                                                                               Pageable pageable);
}
