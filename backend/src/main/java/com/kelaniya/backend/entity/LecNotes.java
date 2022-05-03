package com.kelaniya.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity(name = "lecture_notes")
@Table(name = "lecture_notes")
@Data
@NoArgsConstructor
public class LecNotes {



    @Id
    private String file_name;
    private String subjectName;
    private String description;
    private String file_type;
    private long file_size;
    private String academic_year;
    private String date;

    @Lob
    private byte[] data;


    public LecNotes(String subjectName, String description,String file_name,String file_type,String academic_year,byte[] data,long file_size,String date) {
        super();
        this.subjectName = subjectName;
        this.description = description;
        this.data = data;
        this.academic_year = academic_year;
        this.file_name = file_name;
        this.file_type = file_type;
        this.file_size = file_size;
        this.date = date;
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



    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }






}
