package com.kelaniya.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {
  @GetMapping("/api/v1/public")
  private String forPublic(){
    return "public";
  }
}
