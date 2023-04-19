package com.codegym.register_course.repository;

import com.codegym.register_course.model.Enrollment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    //    @Query(value = "SELECT s.studentName, s.studentEmail, e.enrollmentStatus, e.enrollmentDate, c.courseName FROM Enrollment e JOIN e.student s JOIN e.course c", nativeQuery = true)
//    List<Object[]> findAllEnrollment();
    Page<Enrollment> findAllByEnrollmentIDContaining(String name, PageRequest pageRequest);

    Page<Enrollment> findAll(Pageable pageable);
}
