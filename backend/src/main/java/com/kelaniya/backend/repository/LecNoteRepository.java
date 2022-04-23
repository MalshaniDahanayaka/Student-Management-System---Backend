package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.LecNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LecNoteRepository extends JpaRepository<LecNotes,String>{


}
