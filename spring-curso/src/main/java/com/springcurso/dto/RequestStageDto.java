package com.springcurso.dto;

import com.springcurso.domain.Request;
import com.springcurso.domain.RequestStage;
import com.springcurso.domain.Usuario;
import com.springcurso.domain.enums.RequestState;

import javax.validation.constraints.NotNull;

public class RequestStageDto {
  private String description;

  @NotNull(message = "State required")
  private RequestState state;

  @NotNull(message = "Request required")
  private Request request;

  @NotNull(message = "User required")
  private Usuario user;

  public RequestStage transformToRequestStage() {
    RequestStage stage = new RequestStage();

    stage.setDescription(getDescription());
    stage.setState(getState());
    stage.setRequest(getRequest());
    stage.setUser(getUser());

    return stage;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public RequestState getState() {
    return state;
  }

  public void setState(RequestState state) {
    this.state = state;
  }

  public Request getRequest() {
    return request;
  }

  public void setRequest(Request request) {
    this.request = request;
  }

  public Usuario getUser() {
    return user;
  }

  public void setUser(Usuario user) {
    this.user = user;
  }
}
