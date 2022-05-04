package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.Students;
import com.kelaniya.backend.entity.StudentsEnrollSubjects;
import com.kelaniya.backend.entity.StudentsEnrollSubjectsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentsEnrollSubjectsRepository extends JpaRepository<StudentsEnrollSubjects, StudentsEnrollSubjectsPK> {

    @Transactional
    @Query("FROM students_enroll_subjects where student_email = ?1")
    List<StudentsEnrollSubjects> getStudentEnrollSubjects(String studentEmail);

}
