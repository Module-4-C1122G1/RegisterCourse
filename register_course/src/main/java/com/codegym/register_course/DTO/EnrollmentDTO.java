package com.codegym.register_course.DTO;

import com.codegym.register_course.model.Course;

import javax.persistence.*;

public class EnrollmentDTO {
    private Integer enrollmentID;
    private String personName;
    private String personEmail;
    private String personPhone;
    private String enrollmentDate;
    private String enrollmentStatus;
    private Course course;

    public EnrollmentDTO() {
    }

    public EnrollmentDTO(Integer enrollmentID, String personName, String personEmail, String personPhone, String enrollmentDate, String enrollmentStatus, Course course) {
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
