package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.Faculty;
import com.kelaniya.backend.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicService {
  @Autowired
  private FacultyRepository facultyRepository;

  public List<Faculty> getAllFaculty(){
    return facultyRepository.findAll();
  }

}
