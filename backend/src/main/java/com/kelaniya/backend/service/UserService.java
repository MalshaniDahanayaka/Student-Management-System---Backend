package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.Role;
import com.kelaniya.backend.entity.User;
import com.kelaniya.backend.repository.RoleRepository;
import com.kelaniya.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User addRole(User user){
    return userRepository.save(user);
  }

  public void initUserRolesAndAdmin(){
    Role lecturerRole = new Role();
    lecturerRole.setRoleName("Lecturer");
    lecturerRole.setRoleDescription("Lecturer role");
    roleRepository.save(lecturerRole);

    Role studentRole = new Role();
    studentRole.setRoleName("Student");
    studentRole.setRoleDescription("Student role");
    roleRepository.save(studentRole);

    // create lecture user
    User lecture = new User();
    lecture.setUsername("lecture1");
    lecture.setPassword(getEncodePassword("lecture123"));
    Set<Role> lectureUserRoles = new HashSet<>();
    lectureUserRoles.add(lecturerRole);
    lecture.setRole(lectureUserRoles);
    userRepository.save(lecture);

    // create student user
    User student = new User();
    student.setUsername("student1");
    student.setPassword(getEncodePassword("student123"));
    Set<Role> studentUserRoles = new HashSet<>();
    studentUserRoles.add(studentRole);
    student.setRole(studentUserRoles);
    userRepository.save(student);
  }

  public String getEncodePassword(String password) {
    return passwordEncoder.encode(password);
  }

}
