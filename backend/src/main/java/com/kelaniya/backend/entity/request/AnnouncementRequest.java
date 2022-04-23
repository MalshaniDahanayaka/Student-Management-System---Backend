package com.kelaniya.backend.entity.request;

public class AnnouncementRequest {

    private String lecturer_email;
    private String title;
    private String body;
    private String category;

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
