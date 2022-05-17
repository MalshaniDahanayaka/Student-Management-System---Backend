package com.kelaniya.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity(name = "students_enroll_subjects")
@Table(name = "students_enroll_subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentsEnrollSubjects {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String student_email;
    private String enrolled_course_id;
    private String academic_year;


    public StudentsEnrollSubjects(String student_email, String enrolled_course_id, String academic_year) {
        this.student_email = student_email;
        this.enrolled_course_id = enrolled_course_id;
        this.academic_year = academic_year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getEnrolled_course_id() {
        return enrolled_course_id;
    }

    public void setEnrolled_course_id(String enrolled_course_id) {
        this.enrolled_course_id = enrolled_course_id;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }
}
