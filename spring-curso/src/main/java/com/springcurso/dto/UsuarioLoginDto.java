package com.springcurso.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioLoginDto {

  @JsonProperty("email")
  @Email(message = "Invalid email address")
  private String email;

  @JsonProperty("password")
  @NotBlank(message = "Invalid password, not blank")
  private String password;

  public UsuarioLoginDto(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "UsuarioLoginDto [email=" + email + ", password=" + password + "]";
  }
}
