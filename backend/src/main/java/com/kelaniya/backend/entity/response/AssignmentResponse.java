package com.kelaniya.backend.entity.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AssignmentResponse {

    private String file_name;
    private String subject_id;
    private String assignment_name;
    private String assignment_description;
    private String final_submit_date;
    private String download_URL;
    private long file_size;
    private String date;

    public AssignmentResponse(String file_name, String subject_id, String assignment_name, String assignment_description, String final_submit_date, String download_URL, long file_size, String date) {
        this.file_name = file_name;
        this.subject_id = subject_id;
        this.assignment_name = assignment_name;
        this.assignment_description = assignment_description;
        this.final_submit_date = final_submit_date;
        this.download_URL = download_URL;
        this.file_size = file_size;
        this.date = date;
    }
}
