package com.kelaniya.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "role")
@Table(name = "role")
public class Role {
   @Id
   private String roleName;
   private String roleDescription;

   public String getRoleName() {
      return roleName;
   }

   public void setRoleName(String roleName) {
      this.roleName = roleName;
   }

   public String getRoleDescription() {
      return roleDescription;
   }

   public void setRoleDescription(String roleDescription) {
      this.roleDescription = roleDescription;
   }
}
