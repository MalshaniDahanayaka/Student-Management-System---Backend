package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.LecNotes;
import com.kelaniya.backend.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface LecNoteRepository extends JpaRepository<LecNotes,String>{

    @Transactional
    @Query("FROM lecture_notes WHERE subjectName = ?1 AND academic_year = ?2")
    List<LecNotes> getSelectedCourseLecNotes(String courseId, String academicYear);


}
