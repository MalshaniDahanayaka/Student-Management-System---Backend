package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.StudentsRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface StudentsRecordsRepository extends JpaRepository<StudentsRecords,String> {

    @Modifying
    @Transactional
    @Query("UPDATE students_records SET score = ?3 ,grade = ?4 WHERE student_email = ?1 AND course_id = ?2")
    public int updateMarksAndGrades(String student_email,String course_id,double score,String grade);

}
