package com.codegym.register_course.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseID;
    @Column(name = "course_name", columnDefinition = "varchar(45)")
    @NotBlank(message = "Vui lòng không để trống tên khóa học")
    private String courseName;
    @Column(name = "course_description", columnDefinition = "text")
    @NotBlank(message = "Vui lòng không để trống mô tả")
    private String courseDescription;
    @Column(name = "start_date", columnDefinition = "varchar(45)")
    @NotBlank(message = "Vui lòng không để trống ngày bắt đầu")
    private String startDate;
    @Column(name = "end_date", columnDefinition = "varchar(45)")
    @NotBlank(message = "Vui lòng không để trống ngày kết thúc")
    private String endDate;
    @Column(name = "course_location", columnDefinition = "varchar(255)")
    @NotBlank(message = "Vui lòng không để trống vị trí")
    private String courseLocation;
    @Column(name = "course_price", columnDefinition = "varchar(45)")
    @NotBlank(message = "Vui lòng không để trống giá")
    private String coursePrice;
    @Column(name = "student_max")
    @NotNull(message = "Vui lòng không để trống số lượng học viên")
    private Integer studentMax;
    @Column(name = "course_status", columnDefinition = "varchar(45)")
    @NotBlank(message = "Vui lòng không để trống trạng thái")
    private String courseStatus;
    @Column(name = "course_img", columnDefinition = "varchar(255)")
    @NotBlank(message = "Vui lòng không để trống ảnh")
    private String courseImg;

    @Column(name = "duration",columnDefinition = "varchar(45)")
    @NotBlank(message = "Vui lòng không để trống thời lượng")
    private String duration;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;
    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Course() {
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Course(Integer courseID, String courseName, String courseDescription, String startDate, String endDate, String courseLocation, String coursePrice, Integer studentMax, String courseStatus, String courseImg, String duration, Lecturer lecturer, Employee employee) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseLocation = courseLocation;
        this.coursePrice = coursePrice;
        this.studentMax = studentMax;
        this.courseStatus = courseStatus;
        this.courseImg = courseImg;
        this.duration = duration;
        this.lecturer = lecturer;
        this.employee = employee;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Integer getStudentMax() {
        return studentMax;
    }

    public void setStudentMax(Integer studentMax) {
        this.studentMax = studentMax;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
