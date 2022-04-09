package com.kelaniya.backend.controller;

import com.kelaniya.backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

  @Autowired
  private JwtService jwtService;


  @PostMapping("/auth/login")
  public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
    return jwtService.createJwtToken(jwtRequest);
  }
}
