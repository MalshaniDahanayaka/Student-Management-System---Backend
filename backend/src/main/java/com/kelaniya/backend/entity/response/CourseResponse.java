package com.kelaniya.backend.entity.response;

public class CourseResponse {

    private String course_id;
    private String academic_year;


    public CourseResponse(String courseID, String academic_year) {
        this.course_id = courseID;
        this.academic_year = academic_year;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }


    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }
}
