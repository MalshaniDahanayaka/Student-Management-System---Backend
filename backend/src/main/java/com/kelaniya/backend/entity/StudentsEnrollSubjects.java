package com.kelaniya.backend.entity;


import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "students_enroll_subjects")
@Table(name = "students_enroll_subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StudentsEnrollSubjectsPK.class)
public class StudentsEnrollSubjects {


    @Id
    private String student_email;
    @Id
    private String enrolled_course_id;


    public String getEnrolled_course_id() {
        return enrolled_course_id;
    }

    public void setEnrolled_course_id(String enrolled_course_id) {
        this.enrolled_course_id = enrolled_course_id;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }
}
