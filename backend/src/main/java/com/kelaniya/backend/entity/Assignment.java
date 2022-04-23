package com.kelaniya.backend.entity;


import javax.persistence.*;



@Entity(name = "assignments")
@Table(name = "assignments")
public class Assignment {

    @Id
    private String subject_id;
    private String assignment_name;
    private String assignment_description;
    private String final_submit_date;
    private byte[] assignment_file;


    public Assignment(String subject_id, String assignment_name, String assignment_description,
                      String final_submit_date, byte[] bytes) {
        this.subject_id = subject_id;
        this.assignment_name = assignment_name;
        this.assignment_description = assignment_description;
        this.final_submit_date = final_submit_date;
        this.assignment_file = bytes;


    }

    public Assignment() {

    }




    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getAssignment_name() {
        return assignment_name;
    }

    public void setAssignment_name(String assignment_name) {
        this.assignment_name = assignment_name;
    }

    public String getAssignment_description() {
        return assignment_description;
    }

    public void setAssignment_description(String assignment_description) {
        this.assignment_description = assignment_description;
    }

    public String getFinal_submit_date() {
        return final_submit_date;
    }

    public void setFinal_submit_date(String final_submit_date) {
        this.final_submit_date = final_submit_date;
    }

    public byte[] getAssignment_file() {
        return assignment_file;
    }

    public void setAssignment_file(byte[] assignment_file) {
        this.assignment_file = assignment_file;
    }

}
