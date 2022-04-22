package com.kelaniya.backend.entity.response;

public class StudentsRecordsResponse {

    private String student_email;
    private String course_id;
    private double score;
    private String grade;

    public StudentsRecordsResponse(String student_email, String course_id, double score, String grade) {
        this.student_email = student_email;
        this.course_id = course_id;
        this.score = score;
        this.grade = grade;

    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
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
