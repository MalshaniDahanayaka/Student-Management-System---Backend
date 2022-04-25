package com.kelaniya.backend.entity.response;

import com.kelaniya.backend.entity.ResponseUser;
import com.kelaniya.backend.entity.Users;

public class JwtResponse {
  private ResponseUser responseUser;
  private String jwtToken;
  private String message;

  public JwtResponse(String message){
    this.message = message;
  }

  public JwtResponse(Users users, String newToken, String message) {
    this.responseUser = new ResponseUser(users.getUsername(), users.getRole());
    this.jwtToken = newToken;
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ResponseUser getResponseUser() {
    return responseUser;
  }

  public void setResponseUser(ResponseUser responseUser) {
    this.responseUser = responseUser;
  }

  public String getJwtToken() {
    return jwtToken;
  }

  public void setJwtToken(String jwtToken) {
    this.jwtToken = jwtToken;
  }
}
