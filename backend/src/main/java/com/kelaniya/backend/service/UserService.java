package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.Role;
import com.kelaniya.backend.entity.Students;
import com.kelaniya.backend.entity.Users;
import com.kelaniya.backend.entity.UsersRole;
import com.kelaniya.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRoleRepository userRoleRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private LecturerRepository lecturerRepository;

  public void initUserRolesAndAdmin(){

    // create lecturer role
    Role lecturerRole = new Role();
    lecturerRole.setRoleName("Lecturer");
    lecturerRole.setRoleDescription("Lecturer role");
    roleRepository.save(lecturerRole);

    // create student role
    Role studentRole = new Role();
    studentRole.setRoleName("Student");
    studentRole.setRoleDescription("Student role");
    roleRepository.save(studentRole);

    // create lecture user
    Users lecture = new Users();
    lecture.setUsername("lecture1");
    lecture.setPassword(getEncodePassword("lecture123"));
    Set<Role> lectureUserRoles = new HashSet<>();
    lectureUserRoles.add(lecturerRole);
    lecture.setRole(lectureUserRoles);
    userRepository.save(lecture);

    // create student user
    Users student = new Users();
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

  public Optional<UsersRole> getUserRole(String userEmail){
    return userRoleRepository.findById(userEmail);
  }

  public Students getUserStudentDetails(String std_email){
    return studentRepository.getUserStudentDetails(std_email);
  }

}
