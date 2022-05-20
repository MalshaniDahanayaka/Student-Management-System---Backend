package com.kelaniya.backend.entity.response;

public class StudentsMarksForLecturer {

    private String student_id;
    private String course_id;
    private double score;
    private String grade;

    public StudentsMarksForLecturer(String student_id, String course_id, double score, String grade){
        this.student_id = student_id;
        this.course_id = course_id;
        this.score = score;
        this.grade = grade;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
