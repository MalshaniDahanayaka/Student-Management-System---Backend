package com.kelaniya.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StudentsEnrollSubjectsPK implements Serializable {

    private String student_email;
    private String enrolled_course_id;
}
