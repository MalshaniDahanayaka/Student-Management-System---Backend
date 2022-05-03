package com.kelaniya.backend.entity.request;

import org.springframework.web.multipart.MultipartFile;


public class LectureNotesRequestBody {

    private String subjectName;
    private String description;
    private String academic_year;
    private MultipartFile file;

    public LectureNotesRequestBody(String subjectName,String description,String academic_year,MultipartFile file){
        this.subjectName = subjectName;
        this.description = description;
        this.academic_year = academic_year;
        this.file = file;
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


    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
