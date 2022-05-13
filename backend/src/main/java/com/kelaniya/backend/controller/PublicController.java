package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.Faculty;
import com.kelaniya.backend.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublicController {

  @Autowired
  private PublicService publicService;

  @GetMapping("/api/v1/public")
  private String forPublic(){
    return "public";
  }

  @GetMapping("/api/v1/public/faculty")
  private List<Faculty> getAllFaculty(){
    return publicService.getAllFaculty();
  }
}
