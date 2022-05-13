package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.Lecturers;
import com.kelaniya.backend.entity.Students;
import com.kelaniya.backend.entity.Users;
import com.kelaniya.backend.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class LectureController {

  @Autowired
  private LecturerService lecturerService;

  @GetMapping("/api/v1/lecturer")
  @PreAuthorize("hasRole('Lecture')")
  public String lecture(){
    return "For Lecturer";
  }

  //Add new lecturer profile
  @PostMapping("/api/v1/lecturer/update-profile")
  public Lecturers addNewProfile(@RequestBody  Lecturers lecturer){
    return lecturerService.addNewProfile(lecturer);
  }

  @GetMapping("/api/v1/lecturer/profile")
  public Lecturers getLecturerProfile(HttpServletRequest request){
    HttpSession session = request.getSession();
    String email = (String) session.getAttribute("userEmail");

    return lecturerService.getLecturerProfile(email);
  }

  //get all students profile
  @GetMapping("/api/v1/lecturer/get-all-profiles")
  public List<Lecturers> getAllProfile(){
    return lecturerService.getAllProfile();
  }
}
