package com.kelaniya.backend.entity.request;

public class StudentsEnrollSubjectRequest {

    private String enrolled_course_id;
    private String academic_year;

    public String getEnrolled_course_id() {
        return enrolled_course_id;
    }

    public void setEnrolled_course_id(String enrolled_course_id) {
        this.enrolled_course_id = enrolled_course_id;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }
}
