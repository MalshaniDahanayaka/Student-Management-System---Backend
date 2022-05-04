package com.kelaniya.backend.entity.request;

public class StudentsRecordsRequest {

    private String student_email;
    private String course_id;
    private double score;
    private String grade;

    public StudentsRecordsRequest(String student_email, String enrolled_course_id, double score, String grade) {
        this.student_email = student_email;
        this.course_id = enrolled_course_id;
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
