package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CourseRepository extends JpaRepository<Courses,String> {


    @Transactional
    @Query("FROM courses WHERE course_id = ?1")
    Courses getDetailsAboutSelectedCourseModule(String courseID);


    @Modifying
    @Transactional
    @Query("DELETE FROM courses WHERE course_id = ?1 AND academic_year = ?2")
    public int deleteSelectedCourseModule(String courseID,String academic_year);


    @Query("FROM courses WHERE department_name = ?1")
    List<Courses> getUserDepartmentCourseModules(String departmentID);




}
