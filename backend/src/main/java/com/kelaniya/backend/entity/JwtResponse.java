package com.kelaniya.backend.entity;

public class JwtResponse {
  private User user;
  private String jwtToken;

  public JwtResponse(User user, String newToken) {
    this.user = user;
    this.jwtToken = newToken;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getJwtToken() {
    return jwtToken;
  }

  public void setJwtToken(String jwtToken) {
    this.jwtToken = jwtToken;
  }
}
