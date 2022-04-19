package com.kelaniya.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "lecture_notes")
public class LecNotes {



    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String subjectName;
    private String description;
    private byte[] data;
    private String docType;
    private String date;


    public LecNotes(String subjectName, String description,byte[] data,String docType) {
        super();
        this.subjectName = subjectName;
        this.description = description;
        this.docType = docType;
        this.data = data;

    }

    public LecNotes() {

    }


    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }
}
