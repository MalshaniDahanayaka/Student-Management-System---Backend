package com.kelaniya.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String lecturer_email;
    private String title;
    private String body;
    private String category;

    public Announcement(String lecturer_email, String title, String body, String category) {
        this.lecturer_email = lecturer_email;
        this.title = title;
        this.body = body;
        this.category = category;
    }

    public Announcement() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
