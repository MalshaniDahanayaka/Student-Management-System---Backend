package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.Lecturers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends CrudRepository<Lecturers, String> {

}
