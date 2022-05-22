package com.kelaniya.backend.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data

public class LectureNotesResponse {

    private String subject_name;
    private String description;
    private String academic_year;
    private String file_name;
    private String download_url;
    private long file_size;
    private String date;


    public LectureNotesResponse(String subject_name, String description, String academic_year, String file_name, String download_url, long file_size, String date) {
        this.subject_name = subject_name;
        this.description = description;
        this.academic_year = academic_year;
        this.file_name = file_name;
        this.download_url = download_url;
        this.file_size = file_size;
        this.date = date;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public long getFile_size() {
        return file_size;
    }

    public void setFile_size(long file_size) {
        this.file_size = file_size;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
