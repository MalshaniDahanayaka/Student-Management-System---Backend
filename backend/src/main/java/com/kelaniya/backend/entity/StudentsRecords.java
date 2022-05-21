package com.kelaniya.backend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="students_records")
@Table(name = "students_records")
@Data
@IdClass(StudentRecordsPK.class)
public class StudentsRecords {

    @Id
    private String student_email;
    @Id
    private String course_id;
    private double score;
    private String grade;


    public StudentsRecords(){

    }

    public StudentsRecords(String student_email, String course_id, double score, String grade) {
        this.student_email = student_email;
        this.course_id = course_id;
        this.score = score;
        this.grade = grade;


    }




    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


}
