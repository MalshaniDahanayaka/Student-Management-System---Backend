package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment,String> {
}
