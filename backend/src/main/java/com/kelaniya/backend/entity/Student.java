package com.kelaniya.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
  @Id
  private String student_email;
  private String student_id;
  private String first_name;
  private String last_name;
  private String department;
  private String profile_pic;

  public String getStudent_email() {
    return student_email;
  }

  public void setStudent_email(String student_email) {
    this.student_email = student_email;
  }

  public String getStudent_id() {
    return student_id;
  }

  public void setStudent_id(String student_id) {
    this.student_id = student_id;
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
