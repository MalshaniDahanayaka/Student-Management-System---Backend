package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.User;
import com.kelaniya.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @PostMapping("/api/v1/auth/add-user")
  public User addUser(User user){
    return  userService.addRole(user);
  }

}
