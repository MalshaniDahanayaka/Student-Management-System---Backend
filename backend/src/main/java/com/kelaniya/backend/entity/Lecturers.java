package com.kelaniya.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "lecturers")
@Table(name = "lecturers")
public class Lecturers {

  @Id
  private String lecturer_email;
  private String first_name;
  private String last_name;
  private String department;
  private String profile_pic;

  public String getLecturer_email() {
    return lecturer_email;
  }

  public void setLecturer_email(String lecturer_email) {
    this.lecturer_email = lecturer_email;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getProfile_pic() {
    return profile_pic;
  }

  public void setProfile_pic(String profile_pic) {
    this.profile_pic = profile_pic;
  }
}
