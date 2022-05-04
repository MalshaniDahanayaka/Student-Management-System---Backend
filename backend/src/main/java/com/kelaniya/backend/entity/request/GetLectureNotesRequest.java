package com.kelaniya.backend.entity.request;

public class GetLectureNotesRequest {

    private String subject_name;
    private String academic_year;

    public GetLectureNotesRequest(String subject_name, String academic_year){
        this.subject_name = subject_name;
        this.academic_year = academic_year;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }
}
