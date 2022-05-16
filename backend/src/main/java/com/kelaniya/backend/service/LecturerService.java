package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.Lecturers;
import com.kelaniya.backend.entity.Role;
import com.kelaniya.backend.entity.Users;
import com.kelaniya.backend.repository.LecturerRepository;
import com.kelaniya.backend.repository.RoleRepository;
import com.kelaniya.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LecturerService {

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private LecturerRepository lecturerRepository;

  public Lecturers addNewProfile(Lecturers lecturers){
    return lecturerRepository.save(lecturers);
  }

  public List<Lecturers> getAllProfile(){
    return lecturerRepository.findAll();
  }

  public Lecturers getLecturerProfile(String lectureEmail){
    return lecturerRepository.getLecturerProfile(lectureEmail);
  }
}
