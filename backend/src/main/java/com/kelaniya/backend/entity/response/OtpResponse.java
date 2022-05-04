package com.kelaniya.backend.entity.response;


public class OtpResponse {
  String email;
  Integer otp;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getOtp() {
    return otp;
  }

  public void setOtp(Integer otp) {
    this.otp = otp;
  }
}
