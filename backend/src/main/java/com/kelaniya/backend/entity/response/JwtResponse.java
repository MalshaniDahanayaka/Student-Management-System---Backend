package com.kelaniya.backend.entity;

public class JwtResponse {
  private Users users;
  private String jwtToken;

  public JwtResponse(Users users, String newToken) {
    this.users = users;
    this.jwtToken = newToken;
  }

  public Users getUser() {
    return users;
  }

  public void setUser(Users users) {
    this.users = users;
  }

  public String getJwtToken() {
    return jwtToken;
  }

  public void setJwtToken(String jwtToken) {
    this.jwtToken = jwtToken;
  }
}
