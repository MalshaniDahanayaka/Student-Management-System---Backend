package com.kelaniya.backend.entity.response;

public class StudentsMarksForLecturer {

    private String student_email;
    private String student_id;
    private String first_name;
    private String last_name;
    private String course_id;
    private double score;
    private String grade;

    public StudentsMarksForLecturer(String student_email, String student_id, String first_name, String last_name, String course_id, double score, String grade){
        this.student_email = student_email;
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.course_id = course_id;
        this.score = score;
        this.grade = grade;
    }
    public String getStudentEmail() {
        return student_email;
    }

    public void setStudentEmail(String student_email) {
        this.student_email = student_email;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
