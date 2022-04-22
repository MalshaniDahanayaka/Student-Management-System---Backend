package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.request.JwtRequest;
import com.kelaniya.backend.entity.response.JwtResponse;
import com.kelaniya.backend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class authController {

  @Autowired
  private LoginService loginService;


  @PostMapping("/api/v1/auth/login")
  public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
    return loginService.createJwtToken(jwtRequest);
  }
}
