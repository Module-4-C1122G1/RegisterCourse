package com.codegym.register_course.model;

import javax.persistence.*;

@Entity
@Table(name = "lecturer")
public class Lecturer {
    @Id
    @Column(name = "lecturer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lecturerID;
    @Column(name = "lecturer_name", columnDefinition = "varchar(45)")
    private String lecturerName;
    @Column(name = "lecturer_email", columnDefinition = "varchar(255)")
    private String lecturerEmail;
    @Column(name = "lecturer_phone", columnDefinition = "varchar(45)")
    private String lecturerPhone;
    @Column(name = "lecturer_img", columnDefinition = "varchar(255)")
    private String lecturerImg;
    @Column(name = "lecturer_position",columnDefinition = "varchar(255)")
    private String lecturerPosition;
    public Lecturer() {
    }

    public Lecturer(Integer lecturerID, String lecturerName, String lecturerEmail, String lecturerPhone, String lecturerImg, String lecturerPosition) {
        this.lecturerID = lecturerID;
        this.lecturerName = lecturerName;
        this.lecturerEmail = lecturerEmail;
        this.lecturerPhone = lecturerPhone;
        this.lecturerImg = lecturerImg;
        this.lecturerPosition = lecturerPosition;
    }

    public String getLecturerPosition() {
        return lecturerPosition;
    }

    public void setLecturerPosition(String lecturerPosition) {
        this.lecturerPosition = lecturerPosition;
    }

    public Integer getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(Integer lecturerID) {
        this.lecturerID = lecturerID;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getLecturerEmail() {
        return lecturerEmail;
    }

    public void setLecturerEmail(String lecturerEmail) {
        this.lecturerEmail = lecturerEmail;
    }

    public String getLecturerPhone() {
        return lecturerPhone;
    }

    public void setLecturerPhone(String lecturerPhone) {
        this.lecturerPhone = lecturerPhone;
    }

    public String getLecturerImg() {
        return lecturerImg;
    }

    public void setLecturerImg(String lecturerImg) {
        this.lecturerImg = lecturerImg;
    }
}
