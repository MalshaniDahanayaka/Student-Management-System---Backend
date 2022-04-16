package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Students, String> {
}
