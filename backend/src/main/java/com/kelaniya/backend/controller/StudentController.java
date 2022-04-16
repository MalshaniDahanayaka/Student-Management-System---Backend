package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.Student;
import com.kelaniya.backend.entity.User;
import com.kelaniya.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  @Autowired
  private StudentService studentService;


  @GetMapping("/api/v1/student")
  @PreAuthorize("hasRole('Student')")
  public String user(){
    return "For Student";
  }

  @PostMapping("/api/v1/auth/signup-student")
  public User addUser(@RequestBody User user){
    return  studentService.signupStudent(user);
  }

  @PostMapping("/api/v1/student/update-details")
  public Student updateDetails(@RequestBody Student student){
      return studentService.updateDetails(student);
  }
}
