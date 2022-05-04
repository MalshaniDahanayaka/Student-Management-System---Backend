package com.kelaniya.backend.entity.request;

public class DeleteAnnouncementRequest {


    private String title;
    private String academic_year;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }
}
