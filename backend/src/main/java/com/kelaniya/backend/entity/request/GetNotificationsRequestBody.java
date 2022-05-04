package com.kelaniya.backend.entity.request;

public class GetNotificationsRequestBody {

    private String department_name;
    private String academic_year;
    private String faculty_name;

    public GetNotificationsRequestBody(String category,String academic_year,String faculty_name){
        this.department_name = category;
        this.academic_year = academic_year;
        this.faculty_name = faculty_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }
}
