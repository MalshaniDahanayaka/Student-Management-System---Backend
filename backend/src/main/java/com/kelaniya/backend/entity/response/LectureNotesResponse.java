package com.kelaniya.backend.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data

public class LectureNotesResponse {

    private String subjectName;
    private String description;
    private String academic_year;
    private String file_name;
    private String download_url;
    private long file_size;
    private String date;


    public LectureNotesResponse(String subjectName, String description, String academic_year, String file_name, String download_url, long file_size, String date) {
        this.subjectName = subjectName;
        this.description = description;
        this.academic_year = academic_year;
        this.file_name = file_name;
        this.download_url = download_url;
        this.file_size = file_size;
        this.date = date;
    }
}
