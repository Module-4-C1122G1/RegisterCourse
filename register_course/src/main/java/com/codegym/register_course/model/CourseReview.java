package com.codegym.register_course.model;

import javax.persistence.*;

@Entity
@Table(name = "course_review")
public class CourseReview {
    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewID;
    @Column(name = "review_content", columnDefinition = "varchar(255)")
    private String reviewContent;
    @Column(name = "review_rating")
    private double reviewRating;
    @Column(name = "review_date", columnDefinition = "varchar(45)")
    private String reviewDate;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id")
    private Student student;

    public CourseReview() {
    }

    public CourseReview(Integer reviewID, String reviewContent, double reviewRating, String reviewDate, Student student) {
        this.reviewID = reviewID;
        this.reviewContent = reviewContent;
        this.reviewRating = reviewRating;
        this.reviewDate = reviewDate;
        this.student = student;
    }

    public Integer getReviewID() {
        return reviewID;
    }

    public void setReviewID(Integer reviewID) {
        this.reviewID = reviewID;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public double getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(double reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
