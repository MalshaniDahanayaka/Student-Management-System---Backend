package com.kelaniya.backend.entity.request;

import org.springframework.web.multipart.MultipartFile;

public class AssignmentRequest {

    private String subject_id;
    private String assignment_name;
    private String assignment_description;
    private String final_submit_date;
    private MultipartFile file;

    public AssignmentRequest(String subject_id,String assignment_name,String assignment_description,String final_submit_date,MultipartFile file){
        this.subject_id = subject_id;
        this.assignment_name = assignment_name;
        this.assignment_description = assignment_description;
        this.final_submit_date = final_submit_date;
        this.file = file;

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


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }


}
