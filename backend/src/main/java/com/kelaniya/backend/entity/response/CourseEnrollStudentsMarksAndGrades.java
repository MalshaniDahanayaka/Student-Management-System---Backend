package com.kelaniya.backend.entity.response;

public class CourseEnrollStudentsMarksAndGrades {

    private String student_email;
    private String enrolled_course_id;
    private String student_id;
    private double score;
    private String grade;

    public CourseEnrollStudentsMarksAndGrades(String student_email,String enrolled_course_id,
                                              String student_id,double score,String grade){
        this.student_email = student_email;
        this.enrolled_course_id = enrolled_course_id;
        this.student_id = student_id;
        this.score = score;
        this.grade = grade;

    }


    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getEnrolled_course_id() {
        return enrolled_course_id;
    }

    public void setEnrolled_course_id(String enrolled_course_id) {
        this.enrolled_course_id = enrolled_course_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
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
