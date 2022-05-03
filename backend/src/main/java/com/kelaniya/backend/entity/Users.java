package com.kelaniya.backend.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
@Table(name = "users")
public class Users {
  @Id
  private String username;
  private String password;


  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "USER_ROLE",
          joinColumns = {
                  @JoinColumn(name = "USER_ID")
          },
          inverseJoinColumns = {
                  @JoinColumn(name = "ROLE_ID")
          }
  )

  private Set<Role> role;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRole() {
    return role;
  }

  public void setRole(Set<Role> role) {
    this.role = role;
  }
}
