package com.kelaniya.backend.controller;

import com.kelaniya.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostConstruct
  public void initUserRolesAndAdmin(){
    userService.initUserRolesAndAdmin();
  }


}
