package com.springcurso.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springcurso.domain.enums.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String name;

    @Column(length = 75, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Request> requests = new ArrayList<Request>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<RequestStage> stages = new ArrayList<RequestStage>();

    public Usuario() {
    }

    public Usuario(
            String name,
            String email,
            String password,
            Role role,
            List<Request> requests,
            List<RequestStage> stages) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.requests = requests;
        this.stages = stages;
    }

    public Usuario(
            Long id,
            String name,
            String email,
            String password,
            Role role,
            List<Request> requests,
            List<RequestStage> stages) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.requests = requests;
        this.stages = stages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @JsonIgnore
    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
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
        return "Usuario [id="
                + id
                + ", name="
                + name
                + ", email="
                + email
                + ", password="
                + password
                + ", role="
                + role
                + ", requests="
                + requests
                + ", stages="
                + stages
                + "]";
    }
}
