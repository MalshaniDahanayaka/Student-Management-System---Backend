package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.Students;
import com.kelaniya.backend.entity.UsersRole;
import com.kelaniya.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostConstruct
  public void initUserRolesAndAdmin(){
    userService.initUserRolesAndAdmin();
  }

  @GetMapping("/api/v1/user/role/{userEmail}")
  public Optional<UsersRole> getUserRole(@PathVariable String userEmail) {

    return userService.getUserRole(userEmail);
  }


  @GetMapping("api/v1/user/details_std/")
  public Students getAllStudentUserDetails(HttpServletRequest request){
    HttpSession session = request.getSession();
    String userEmail = (String) session.getAttribute("userEmail");

    return userService.getUserStudentDetails(userEmail);

  }


}
