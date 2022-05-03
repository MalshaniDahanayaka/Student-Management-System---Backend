package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.*;
import com.kelaniya.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private StudentsEnrollSubjectsRepository studentsEnrollSubjectsRepository;

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



  public Courses getSelectedCourseDetails(String courseID){

    return courseRepository.getDetailsAboutSelectedCourseModule(courseID);

  }




  public List<StudentsEnrollSubjects> getEnrollCourses(String userEmail){

    return studentsEnrollSubjectsRepository.getStudentEnrollSubjects(userEmail);

  }


  public List<Courses> getUserDepartmentCourseModules(String departmentName){
    return courseRepository.getUserDepartmentCourseModules(departmentName);
  }

  public List<Courses> getAllCourses(){
    return courseRepository.findAll();
  }



}
