package com.codegym.register_course.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "curriculum")
public class Curriculum {
    @Id
    @Column(name = "curriculum_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer curriculumID;
    @Column(name = "curriculum_name", columnDefinition = "varchar(45)")
    @Size(min =5, max =300, message = "Tên tối thiểu 5 ký tự, tố đa 300 ký tự")
    @NotBlank(message ="Vui lòng không để trống tên")
    private String curriculumName;
    @Column(name = "curriculum_description", columnDefinition = "text")
    @Size(min =15, max =1000, message = "Nội dung tối thiểu 15 ký tự, tố đa 1000 ký tự")
    @NotBlank(message ="Vui lòng không để trống Nội dung")
    private String curriculumDescription;
    @Column(name = "curriculum_status", columnDefinition = "varchar(45)")
    @NotBlank(message ="Vui lòng không để trống Trạng thái")
    private String curriculumStatus;
    @Column(name = "curriculum_img", columnDefinition = "varchar(255)")
    @NotBlank(message ="Vui lòng không để trống ảnh")
    @Pattern(regexp = "^(https?:\\/\\/)?(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)$", message = "Đường dẫn không đúng dạng hợp lệ. Vui lòng kiểm tra lại~!")
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
