package com.springcurso.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springcurso.domain.enums.RequestState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "request")
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String subject;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "criation_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date criationDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestState state;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_user_id"))
    private Usuario user;

    @OneToMany(mappedBy = "request", fetch = FetchType.EAGER)
    private List<RequestStage> stages = new ArrayList<RequestStage>();

    public Request() {
    }

    public Request(long id, RequestState state, Usuario user) {
        this.id = id;
        this.state = state;
        this.user = user;
    }

    public Request(
            String subject,
            String description,
            Date criationDate,
            RequestState state,
            Usuario user,
            List<RequestStage> stages) {
        this.subject = subject;
        this.description = description;
        this.criationDate = criationDate;
        this.state = state;
        this.user = user;
        this.stages = stages;
    }

    public Request(
            Long id,
            String subject,
            String description,
            Date criationDate,
            RequestState state,
            Usuario user,
            List<RequestStage> stages) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.criationDate = criationDate;
        this.state = state;
        this.user = user;
        this.stages = stages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
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

    public Date getCriationDate() {
        return criationDate;
    }

    public void setCriationDate(Date criationDate) {
        this.criationDate = criationDate;
    }

    public RequestState getState() {
        return state;
    }

    public void setState(RequestState state) {
        this.state = state;
    }

    @JsonIgnore
    public List<RequestStage> getStages() {
        return stages;
    }

    public void setStages(List<RequestStage> stages) {
        this.stages = stages;
    }

    @Override
    public String toString() {
        return "Request [id="
                + id
                + ", subject="
                + subject
                + ", description="
                + description
                + ", criationDate="
                + criationDate
                + ", state="
                + state
                + ", user="
                + user
                + ", stages="
                + stages
                + "]";
    }
}
