package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.Lecturers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface LecturerRepository extends JpaRepository<Lecturers,String> {
    @Transactional
    @Query("FROM lecturers where lecturer_email = ?1")
    Lecturers getUserLecturerDetails(String lectureEmail);
}
