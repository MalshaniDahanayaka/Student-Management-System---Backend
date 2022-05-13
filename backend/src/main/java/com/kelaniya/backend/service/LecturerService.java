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
  private UserService userService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private LecturerRepository lecturerRepository;

  public Users signup(Users users){
    Role lectureRole = roleRepository.findById("Lecturer").get();

    Set<Role> roles = new HashSet<>();
    roles.add(lectureRole);
    users.setRole(roles);

    users.setPassword(userService.getEncodePassword((users.getPassword())));;
    return userRepository.save(users);
  }

  public Lecturers addNewProfile(Lecturers lecturers){
    return lecturerRepository.save(lecturers);
  }

  public List<Lecturers> getAllProfile(){
    return lecturerRepository.findAll();
  }
}
