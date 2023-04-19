package com.codegym.register_course.model;

import javax.persistence.*;

@Entity
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @Column(name = "enrollment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollmentID;
    @Column(name = "person_name")
    private String personName;
    @Column(name = "person_email")
    private String personEmail;
    @Column(name = "person_phone")
    private String personPhone;
    @Column(name = "enrollment_date", columnDefinition = "varchar(45)")
    private String enrollmentDate;
    @Column(name = "enrollment_status", columnDefinition = "varchar(45)")
    private String enrollmentStatus;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    public Enrollment() {
    }

    public Enrollment(Integer enrollmentID, String personName, String personEmail, String personPhone, String enrollmentDate, String enrollmentStatus, Course course) {
        this.enrollmentID = enrollmentID;
        this.personName = personName;
        this.personEmail = personEmail;
        this.personPhone = personPhone;
        this.enrollmentDate = enrollmentDate;
        this.enrollmentStatus = enrollmentStatus;
        this.course = course;
    }

    public Integer getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(Integer enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
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
}
