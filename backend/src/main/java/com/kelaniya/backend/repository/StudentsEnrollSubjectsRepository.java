package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.Courses;
import com.kelaniya.backend.entity.Students;
import com.kelaniya.backend.entity.StudentsEnrollSubjects;
import com.kelaniya.backend.entity.StudentsEnrollSubjectsPK;
import com.kelaniya.backend.entity.response.CourseEnrollStudentsMarksAndGrades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentsEnrollSubjectsRepository extends JpaRepository<StudentsEnrollSubjects, StudentsEnrollSubjectsPK> {

    @Transactional
    @Query("FROM students_enroll_subjects where student_email = ?1")
    List<StudentsEnrollSubjects> getStudentEnrollSubjects(String studentEmail);


    @Query("SELECT a.student_email,a.enrolled_course_id, b.student_id,c.score,c.grade FROM students_enroll_subjects a JOIN students b ON a.student_email = b.student_email JOIN students_records c ON a.student_email = c.student_email AND a.enrolled_course_id = c.course_id WHERE a.enrolled_course_id = ?1")
    List<CourseEnrollStudentsMarksAndGrades> getEnrollStudentsMarksAndGrades(String course_id);


    @Modifying
    @Transactional
    @Query("DELETE FROM students_enroll_subjects WHERE enrolled_course_id = ?1 AND student_email = ?2")
     int unenrollFromCourse(String course_id, String userEmail);



}
