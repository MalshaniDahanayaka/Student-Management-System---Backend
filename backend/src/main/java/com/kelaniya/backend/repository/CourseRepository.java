package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CourseRepository extends JpaRepository<Courses,Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM courses WHERE course_id = ?1")
    public int deleteSelectedCourseModule(String courseID);
}
