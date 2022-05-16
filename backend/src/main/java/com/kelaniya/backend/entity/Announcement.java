package com.kelaniya.backend.entity;

import javax.persistence.*;

@Entity(name = "announcement")
@Table(name = "announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String lecturer_email;
    private String title;
    private String body;
    private String category;
    private String academic_year;

    public Announcement(String lecturer_email, String title, String body, String category,String academic_year) {
        this.lecturer_email = lecturer_email;
        this.title = title;
        this.body = body;
        this.category = category;
        this.academic_year = academic_year;
    }

    public Announcement() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }
}
