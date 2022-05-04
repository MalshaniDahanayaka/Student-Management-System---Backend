package com.kelaniya.backend.entity.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentResponse {

    private String file_name;
    private String subject_id;
    private String assignment_name;
    private String assignment_description;
    private String final_submit_date;
    private String download_URL;
    private long file_size;
    private String date;

}
