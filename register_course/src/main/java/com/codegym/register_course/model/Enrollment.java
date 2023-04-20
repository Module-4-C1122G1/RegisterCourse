package com.codegym.register_course.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @Column(name = "enrollment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollmentID;
    @Column(name = "person_name")
    @NotBlank(message = "Không được để trống tên")
    private String personName;
    @Column(name = "person_email")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email không hợp lệ")
    private String personEmail;
    @Column(name = "person_phone")
    @NotBlank(message = "Không được để trống số điện thoại")
    @Pattern(regexp = "\\b\\d{10,11}\\b", message = "Số điện thoại phải 10 hoặc 11 số")
    private String personPhone;
    @Column(name = "enrollment_date", columnDefinition = "varchar(45)")
    private String enrollmentDate;
    @Column(name = "enrollment_status", columnDefinition = "varchar(45)")
    private String enrollmentStatus;
    @Column(name = "course_name")
    private String courseName;
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JoinColumn(name = "course_id")
//    private Course course;

    public Enrollment() {
    }

    public Enrollment(Integer enrollmentID, String personName, String personEmail, String personPhone, String enrollmentDate, String enrollmentStatus, String courseName) {
        this.enrollmentID = enrollmentID;
        this.personName = personName;
        this.personEmail = personEmail;
        this.personPhone = personPhone;
        this.enrollmentDate = enrollmentDate;
        this.enrollmentStatus = enrollmentStatus;
        this.courseName = courseName;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
