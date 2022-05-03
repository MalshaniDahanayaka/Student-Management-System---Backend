package com.kelaniya.backend.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureNotesResponse {

    private String subjectName;
    private String description;
    private String academic_year;
    private String file_name;
    private String download_url;
    private long file_size;
    private String date;



}
