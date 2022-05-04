package com.kelaniya.backend.entity.request;

public class UnenrollFromCourse {

    private String student_email;
    private String enrolled_course_id;

    public UnenrollFromCourse(String student_email,String enrolled_course_id){
        this.student_email = student_email;
        this.enrolled_course_id = enrolled_course_id;
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
}
