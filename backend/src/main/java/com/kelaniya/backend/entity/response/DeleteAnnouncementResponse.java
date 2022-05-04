package com.kelaniya.backend.entity.response;

public class DeleteAnnouncementResponse {

    private String lecturer_email;
    private String title;
    private String academic_year;

    public DeleteAnnouncementResponse(String lecturer_email,String title,String academic_year){
        this.lecturer_email = lecturer_email;
        this.title = title;
        this.academic_year = academic_year;
    }

    public String getLecturer_email() {
        return lecturer_email;
    }

    public void setLecturer_email(String lecturer_email) {
        this.lecturer_email = lecturer_email;
    }

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
