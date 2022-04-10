package com.kelaniya.backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LectureController {

  @GetMapping("/api/v1/lecturer")
  @PreAuthorize("hasRole('Lecture')")
  public String lecture(){
    return "For Lecturer";
  }
}
