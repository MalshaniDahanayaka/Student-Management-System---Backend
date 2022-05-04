package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.Lecturers;
import com.kelaniya.backend.entity.Users;
import com.kelaniya.backend.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LectureController {

  @Autowired
  private LecturerService lecturerService;

  @GetMapping("/api/v1/lecturer")
  @PreAuthorize("hasRole('Lecture')")
  public String lecture(){
    return "For Lecturer";
  }

  @PostMapping("api/v1/auth/signup-lecturer")
  public Users addUser(@RequestBody Users users){
    return lecturerService.signup(users);
  }

  @PostMapping("api/v1/lecturer/update-details")
  public Lecturers updateDetails(@RequestBody Lecturers lecturers){
    return lecturerService.updateDetails(lecturers);
  }

}
