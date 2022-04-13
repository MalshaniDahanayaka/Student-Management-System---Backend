package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

  @Autowired
  public RoleController roleController;

  @PostMapping("/api/v1/add-role")
  public Role addRole(@RequestBody Role role){
    return roleController.addRole(role);
  }
}
