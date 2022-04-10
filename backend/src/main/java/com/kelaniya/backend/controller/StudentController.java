package com.kelaniya.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  @GetMapping("/api/v1/student")
  public String user(){
    return "For Student";
  }
}
