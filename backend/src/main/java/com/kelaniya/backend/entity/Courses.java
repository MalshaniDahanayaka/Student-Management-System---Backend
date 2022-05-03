package com.kelaniya.backend.entity;

import javax.persistence.*;

@Entity(name = "courses")
@Table(name = "courses")
public class Courses {

    @Id
    private String course_id;
    private String course_name;
    private String lecturer;
    private String course_description;
    private String faculty_name;
    private String department_name;
    private String level;
    private String academic_year;
    private String semester;




    public Courses(String courseID, String courseName, String lectureEmail,String course_description,String faculty_name,String department_name,
                   String level,String academic_year,String semester) {
        this.course_id = courseID;
        this.course_name = courseName;
        this.lecturer = lectureEmail;
        this.course_description = course_description;
        this.faculty_name = faculty_name;
        this.department_name = department_name;
        this.level = level;
        this.academic_year = academic_year;
        this.semester = semester;
    }

    public Courses() {

    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }


    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
