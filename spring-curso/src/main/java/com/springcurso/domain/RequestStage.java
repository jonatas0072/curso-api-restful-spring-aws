package com.springcurso.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.springcurso.domain.enums.RequestState;

@Entity
@Table(name = "request_stage")
public class RequestStage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "realization_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date realizationDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestState state;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false, referencedColumnName = "id")
    private Request request;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false, referencedColumnName = "id")
    private Usuario user;

    public RequestStage() {

    }

    public RequestStage(Long id, String description, Date realizationDate,
            RequestState state, Request request, Usuario user) {
        this.id = id;
        this.description = description;
        this.realizationDate = realizationDate;
        this.state = state;
        this.request = request;
        this.user = user;
    }

    public RequestStage(String description, Date realizationDate,
            RequestState state, Request request, Usuario user) {
        super();
        this.description = description;
        this.realizationDate = realizationDate;
        this.state = state;
        this.request = request;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRealizationDate() {
        return realizationDate;
    }

    public void setRealizationDate(Date realizationDate) {
        this.realizationDate = realizationDate;
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

    @Override
    public String toString() {
        return "RequestStage [id=" + id + ", description=" + description
                + ", realizationDate=" + realizationDate + ", state=" + state
                + ", request=" + request + ", user=" + user + "]";
    }
}
