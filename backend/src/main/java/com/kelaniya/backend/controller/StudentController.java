package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.Students;
import com.kelaniya.backend.entity.Users;
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
  public Users addUser(@RequestBody Users users){
    return  studentService.signupStudent(users);
  }

  @PostMapping("/api/v1/student/update-details")
  public Students updateDetails(@RequestBody Students student){
      return studentService.updateDetails(student);
  }
}
