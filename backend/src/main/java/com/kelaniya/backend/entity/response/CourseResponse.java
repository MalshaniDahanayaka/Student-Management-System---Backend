package com.kelaniya.backend.entity.response;

public class CourseResponse {

    private String course_id;
    private String course_name;
    private String lecturer;


    public CourseResponse(String courseID, String courseName, String lectureEmail) {
        this.course_id = courseID;
        this.course_name = courseName;
        this.lecturer = lectureEmail;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }
}
