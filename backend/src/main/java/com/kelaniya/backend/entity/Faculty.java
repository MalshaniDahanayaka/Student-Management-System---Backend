package com.kelaniya.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "faculty")
@Table(name = "faculty")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FacultyPK.class)
public class Faculty {

  @Id
  private String faculty;
  @Id
  private String department;

  public String getFaculty() {
    return faculty;
  }

  public void setFaculty(String faculty) {
    this.faculty = faculty;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }
}
