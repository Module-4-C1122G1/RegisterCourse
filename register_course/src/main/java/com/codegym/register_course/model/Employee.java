package com.codegym.register_course.model;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeID;
    @Column(name = "employee_name", columnDefinition = "varchar(45)")
    private String employeeName;
    @Column(name = "employee_email", columnDefinition = "varchar(255)")
    private String employeeEmail;
    @Column(name = "employee_phone", columnDefinition = "varchar(45)")
    private String employeePhone;
    @Column(name = "employee_address", columnDefinition = "varchar(255)")
    private String employeeAddress;

    public Employee() {
    }

    public Employee(Integer employeeID, String employeeName, String employeeEmail, String employeePhone, String employeeAddress) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        this.employeeAddress = employeeAddress;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
}
