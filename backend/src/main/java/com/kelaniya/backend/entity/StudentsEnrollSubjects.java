package com.kelaniya.backend.entity;


import javax.persistence.*;

@Entity(name = "students_enroll_subjects")
@Table(name = "students_enroll_subjects")
public class StudentsEnrollSubjects {

    @Id
    private int enrolled_course_id;
    private String student_email;

    public StudentsEnrollSubjects() {
    }

    public StudentsEnrollSubjects(int enrolled_course_id, String student_email) {
        this.enrolled_course_id = enrolled_course_id;
        this.student_email = student_email;
    }

    public int getEnrolled_course_id() {
        return enrolled_course_id;
    }

    public void setEnrolled_course_id(int enrolled_course_id) {
        this.enrolled_course_id = enrolled_course_id;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }
}
