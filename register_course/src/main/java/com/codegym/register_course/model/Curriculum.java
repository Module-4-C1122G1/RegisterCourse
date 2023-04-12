package com.codegym.register_course.model;

import javax.persistence.*;

@Entity
@Table(name = "curriculum")
public class Curriculum {
    @Id
    @Column(name = "curriculum_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer curriculumID;
    @Column(name = "curriculum_name", columnDefinition = "varchar(45)")
    private String curriculumName;
    @Column(name = "curriculum_description", columnDefinition = "text")
    private String curriculumDescription;
    @Column(name = "curriculum_status", columnDefinition = "varchar(45)")
    private String curriculumStatus;
    @Column(name = "curriculum_img", columnDefinition = "varchar(255)")
    private String curriculumImg;

    public Curriculum() {
    }

    public Curriculum(Integer curriculumID, String curriculumName, String curriculumDescription, String curriculumStatus, String curriculumImg) {
        this.curriculumID = curriculumID;
        this.curriculumName = curriculumName;
        this.curriculumDescription = curriculumDescription;
        this.curriculumStatus = curriculumStatus;
        this.curriculumImg = curriculumImg;
    }

    public Integer getCurriculumID() {
        return curriculumID;
    }

    public void setCurriculumID(Integer curriculumID) {
        this.curriculumID = curriculumID;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public String getCurriculumDescription() {
        return curriculumDescription;
    }

    public void setCurriculumDescription(String curriculumDescription) {
        this.curriculumDescription = curriculumDescription;
    }

    public String getCurriculumStatus() {
        return curriculumStatus;
    }

    public void setCurriculumStatus(String curriculumStatus) {
        this.curriculumStatus = curriculumStatus;
    }

    public String getCurriculumImg() {
        return curriculumImg;
    }

    public void setCurriculumImg(String curriculumImg) {
        this.curriculumImg = curriculumImg;
    }
}
