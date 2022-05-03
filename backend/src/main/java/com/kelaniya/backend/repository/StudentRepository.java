package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Students, String> {

    @Transactional
    @Query("FROM students where student_email = ?1")
    Students getUserStudentDetails(String studentEmail);

}
