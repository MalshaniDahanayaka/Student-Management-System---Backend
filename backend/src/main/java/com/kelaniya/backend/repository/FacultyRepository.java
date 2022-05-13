package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, String> {

}
