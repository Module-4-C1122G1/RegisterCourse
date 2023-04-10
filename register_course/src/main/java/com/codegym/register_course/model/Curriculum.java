package com.codegym.register_course.model;

import javax.persistence.*;

@Entity
@Table(name = "curriculum")
public class Curriculum {
    @Id
    @Column(name = "curriculum_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer curriculumID;
    @Column(name = "curriculum_name")
    private String curriculumName;
    @Column(name = "curriculum_description")
    private String curriculumDescription;
    @Column(name = "curriculum_status")
    private String curriculumStatus;

    public Curriculum() {
    }

    public Curriculum(Integer curriculumID, String curriculumName, String curriculumDescription, String curriculumStatus) {
        this.curriculumID = curriculumID;
        this.curriculumName = curriculumName;
        this.curriculumDescription = curriculumDescription;
        this.curriculumStatus = curriculumStatus;
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
}
