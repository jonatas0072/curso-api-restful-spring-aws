package com.springcurso.dto;

import com.springcurso.domain.Request;
import com.springcurso.domain.RequestStage;
import com.springcurso.domain.Usuario;
import com.springcurso.domain.enums.RequestState;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class RequestDto {

  @NotBlank(message = "Subject cannot be empty")
  private String subject;

  private String description;

  @NotNull(message = "User cannot be null")
  private Usuario user;

  @NotNull(message = "State required")
  private RequestState state;

  private List<RequestStage> stages = new ArrayList<>();

  public Request transformToRequest() {
    Request request = new Request();

    request.setSubject(getSubject());
    request.setDescription(getDescription());
    request.setUser(getUser());
    request.setState(getState());
    request.setStages(getStages());

    return request;
  }

  public RequestState getState() {
    return state;
  }

  public void setState(RequestState state) {
    this.state = state;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Usuario getUser() {
    return user;
  }

  public void setUser(Usuario user) {
    this.user = user;
  }

  public List<RequestStage> getStages() {
    return stages;
  }

  public void setStages(List<RequestStage> stages) {
    this.stages = stages;
  }

  @Override
  public String toString() {
    return "RequestDto{"
            + "subject='"
            + subject
            + '\''
            + ", description='"
            + description
            + '\''
            + ", user="
            + user
            + ", stages="
            + stages
            + '}';
  }
}
