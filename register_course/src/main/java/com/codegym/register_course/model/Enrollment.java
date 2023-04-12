package com.codegym.register_course.model;

import javax.persistence.*;

@Entity
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @Column(name = "enrollment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollmentID;
    @Column(name = "enrollment_date", columnDefinition = "varchar(45)")
    private String enrollmentDate;
    @Column(name = "enrollment_status", columnDefinition = "varchar(45)")
    private String enrollmentStatus;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id")
    private Student student;

    public Enrollment() {
    }

    public Enrollment(Integer enrollmentID, String enrollmentDate, String enrollmentStatus, Course course, Student student) {
        this.enrollmentID = enrollmentID;
        this.enrollmentDate = enrollmentDate;
        this.enrollmentStatus = enrollmentStatus;
        this.course = course;
        this.student = student;
    }

    public Integer getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(Integer enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
