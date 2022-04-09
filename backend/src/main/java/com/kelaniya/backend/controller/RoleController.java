package com.kelaniya.backend.controller;

import com.kelaniya.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
  @Autowired
  private RoleService roleService;

  @PostMapping("/role")
  public Role createRole(@RequestBody Role role){
    return  roleService.createRole(role);
  }


}
