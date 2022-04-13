package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.Role;
import com.kelaniya.backend.entity.User;
import com.kelaniya.backend.repository.RoleRepository;
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

  public User signupStudent(User user){
    Role StudentRole = roleRepository.findById("Student").get();

    Set<Role> roles = new HashSet<>();
    roles.add(StudentRole);
    user.setRole(roles);

    user.setPassword(userService.getEncodePassword(user.getPassword()));
    return userRepository.save(user);
  }
}
