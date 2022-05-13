package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.Students;
import com.kelaniya.backend.entity.Users;
import com.kelaniya.backend.entity.UsersRole;
import com.kelaniya.backend.entity.request.OtpRequest;
import com.kelaniya.backend.entity.request.SignupRequest;
import com.kelaniya.backend.entity.response.OtpResponse;
import com.kelaniya.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("api/v1/user/get-otp")
  public OtpResponse getOtp(@RequestBody OtpRequest otpRequest){

    return userService.verifyUserEmail(otpRequest.getEmail());
  }

  @PostMapping("api/v1/auth/signup")
  public Users signup(@RequestBody SignupRequest signupRequest){
    return userService.signup(signupRequest);
  }
}
