package com.kelaniya.backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class StudentsEnrollSubjectId implements Serializable {
    private String enrolled_course_id;

    private String student_email;


    public StudentsEnrollSubjectId(){

    }

    public StudentsEnrollSubjectId(String enrolled_course_id, String student_email) {
        this.enrolled_course_id = enrolled_course_id;
        this.student_email = student_email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsEnrollSubjectId studentsEnrollSubjectId = (StudentsEnrollSubjectId) o;
        return enrolled_course_id.equals(studentsEnrollSubjectId.enrolled_course_id) &&
                student_email.equals(studentsEnrollSubjectId.student_email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrolled_course_id, student_email);
    }
}

