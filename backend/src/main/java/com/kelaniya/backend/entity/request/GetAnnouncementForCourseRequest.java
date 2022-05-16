package com.kelaniya.backend.entity.request;

public class GetAnnouncementForCourseRequest {
  private String category;
  private String academicYear;

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getAcademicYear() {
    return academicYear;
  }

  public void setAcademicYear(String academicYear) {
    this.academicYear = academicYear;
  }
}
