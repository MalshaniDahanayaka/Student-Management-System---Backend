package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.Role;
import com.kelaniya.backend.entity.Students;
import com.kelaniya.backend.entity.Users;
import com.kelaniya.backend.repository.RoleRepository;
import com.kelaniya.backend.repository.StudentRepository;
import com.kelaniya.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentService {
  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private StudentRepository studentRepository;

  public Users signupStudent(Users users){
    Role StudentRole = roleRepository.findById("Student").get();

    Set<Role> roles = new HashSet<>();
    roles.add(StudentRole);
    users.setRole(roles);

    users.setPassword(userService.getEncodePassword(users.getPassword()));
    return userRepository.save(users);
  }

  public Students updateDetails(Students student) {
    return studentRepository.save(student);
  }
}
