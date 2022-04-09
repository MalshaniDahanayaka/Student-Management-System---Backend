package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RoleService {
  @Autowired
  private RoleService roleService;

  @PostMapping("/role")
  public Role createRole(@RequestBody Role role){
    return  roleService.createRole(role);
  }
}
