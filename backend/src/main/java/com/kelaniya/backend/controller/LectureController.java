package com.kelaniya.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LectureController {

  @GetMapping("/api/v1/lecturer")
  public String lecture(){
    return "For Lecturer";
  }
}
