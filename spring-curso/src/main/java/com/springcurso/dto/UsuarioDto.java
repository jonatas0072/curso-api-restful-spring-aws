package com.springcurso.dto;

import com.springcurso.domain.Request;
import com.springcurso.domain.RequestStage;
import com.springcurso.domain.Usuario;
import com.springcurso.domain.enums.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDto {

  @NotBlank(message = "Field 'name' cannot be empty.")
  private String name;

  @NotBlank(message = "Field 'email' cannot be empty.")
  @Email(message = "Format the 'email' is invalid ")
  private String email;

  @Size(min = 7, max = 99, message = "Password must be between 7 and 99.")
  private String password;

  @NotNull(message = "Field 'role' cannot be null.")
  private Role role;

  private List<Request> requests = new ArrayList<>();
  private List<RequestStage> stages = new ArrayList<>();

  public Usuario transformToUser() {
    Usuario usuario = new Usuario();
    usuario.setName(getName());
    usuario.setEmail(getEmail());
    usuario.setPassword(getPassword());
    usuario.setRequests(getRequests());
    usuario.setStages(getStages());
    usuario.setRole(getRole());

    return usuario;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public List<Request> getRequests() {
    return requests;
  }

  public void setRequests(List<Request> requests) {
    this.requests = requests;
  }

  public List<RequestStage> getStages() {
    return stages;
  }

  public void setStages(List<RequestStage> stages) {
    this.stages = stages;
  }
}
