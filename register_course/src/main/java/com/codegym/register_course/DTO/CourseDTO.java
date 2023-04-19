package com.codegym.register_course.DTO;

import com.codegym.register_course.model.Employee;
import com.codegym.register_course.model.Lecturer;

import javax.persistence.*;

public class CourseDTO {
    private Integer courseID;

    private String courseName;

    private String courseDescription;

    private String startDate;

    private String endDate;

    private String courseLocation;

    private double coursePrice;

    private Integer studentMax;

    private String courseStatus;

    private String courseImg;

    private Lecturer lecturer;

    private Employee employee;

    public CourseDTO() {
    }

    public CourseDTO(Integer courseID, String courseName, String courseDescription, String startDate, String endDate, String courseLocation, double coursePrice, Integer studentMax, String courseStatus, String courseImg, Lecturer lecturer, Employee employee) {
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

    public double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(double coursePrice) {
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
