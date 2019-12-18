package com.springcurso.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.springcurso.domain.enums.RequestState;

@Entity
@Table(name = "request")
public class Request implements Serializable {

    private static final long serialVersionUID = 5039987690976397173L;

    public Request() {
        super();
    }

    public Request(Long id, String subject, String description,
            Date criationDate, RequestState state, User user,
            List<RequestStage> stages) {
        super();
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.criationDate = criationDate;
        this.state = state;
        this.user = user;
        this.stages = stages;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String subject;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "criation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date criationDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestState state;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "request")
    private List<RequestStage> stages = new ArrayList<RequestStage>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
        return "Request [id=" + id + ", subject=" + subject + ", description="
                + description + ", criationDate=" + criationDate + ", state="
                + state + ", user=" + user + ", stages=" + stages + "]";
    }

}
