package com.kelaniya.backend.entity.request;

import org.springframework.web.bind.annotation.RequestParam;

public class CourseRequest {

    private String course_id;
    private String course_name;
    private String lecturer;

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