package com.codegym.register_course.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(columnNames = "student_email"),
        @UniqueConstraint(columnNames = "student_phone")
})
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentID;
    @Column(name = "student_name", columnDefinition = "varchar(45)")
    @NotBlank(message = "Không được để trống tên học viên")
    private String studentName;
    @Column(name = "student_email", columnDefinition = "varchar(255)")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email không hợp lệ")
    private String studentEmail;
    @Column(name = "student_phone", columnDefinition = "varchar(45)" , unique = true)
    @NotBlank(message = "Không được để trống số điện thoại")
    @Pattern(regexp = "\\b\\d{10,11}\\b", message = "Số điện thoại phải 10 hoặc 11 số")
    private String studentPhone;
    @Column(name = "student_address", columnDefinition = "varchar(255)")
    @NotBlank(message = "Không được để trống địa chỉ")
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
