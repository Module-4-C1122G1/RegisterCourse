package com.codegym.register_course.model;

import javax.persistence.*;

@Entity
@Table(name = "course_curriculum")
public class CourseCurriculum {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "sequence")
    private Integer sequence;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    public CourseCurriculum() {
    }

    public CourseCurriculum(Integer id, Integer sequence, Course course, Curriculum curriculum) {
        this.id = id;
        this.sequence = sequence;
        this.course = course;
        this.curriculum = curriculum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }
}
