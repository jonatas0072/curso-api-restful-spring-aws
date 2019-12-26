package com.springcurso.dto;

public class UsuarioLoginDto {
    private String email;
    private String password;

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

    public UsuarioLoginDto(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public UsuarioLoginDto() {
        super();
    }

    @Override
    public String toString() {
        return "UsuarioLoginDto [email=" + email + ", password=" + password
                + "]";
    }

}
