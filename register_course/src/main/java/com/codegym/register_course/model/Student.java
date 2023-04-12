package com.codegym.register_course.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentID;
    @Column(name = "student_name", columnDefinition = "varchar(45)")
    private String studentName;
    @Column(name = "student_email", columnDefinition = "varchar(255)")
    private String studentEmail;
    @Column(name = "student_phone", columnDefinition = "varchar(45)")
    private String studentPhone;
    @Column(name = "student_address", columnDefinition = "varchar(255)")
    private String studentAddress;
    @Column(name = "student_img", columnDefinition = "varchar(255)")
    private String studentImg;

    public Student() {
    }

    public Student(Integer studentID, String studentName, String studentEmail, String studentPhone, String studentAddress, String studentImg) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
        this.studentAddress = studentAddress;
        this.studentImg = studentImg;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentImg() {
        return studentImg;
    }

    public void setStudentImg(String studentImg) {
        this.studentImg = studentImg;
    }
}
