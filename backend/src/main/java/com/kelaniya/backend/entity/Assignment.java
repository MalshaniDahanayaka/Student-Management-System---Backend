package com.kelaniya.backend.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity(name = "assignments")
@Table(name = "assignments")
@Data
@NoArgsConstructor
public class Assignment {

    @Id
    private String file_name;
    private String subject_id;
    private String assignment_name;
    private String assignment_description;
    private String final_submit_date;
    private String file_type;
    private long file_size;
    private String date;

    @Lob
    private byte[] data;




    public Assignment(String file_name,String subject_id, String assignment_name, String assignment_description,
                      String final_submit_date,String file_type,long file_size, byte[] data,String date) {
        this.file_name = file_name;
        this.subject_id = subject_id;
        this.assignment_name = assignment_name;
        this.assignment_description = assignment_description;
        this.final_submit_date = final_submit_date;
        this.file_type = file_type;
        this.file_size = file_size;
        this.data = data;
        this.date = date;


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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public long getFile_size() {
        return file_size;
    }

    public void setFile_size(long file_size) {
        this.file_size = file_size;
    }
}
