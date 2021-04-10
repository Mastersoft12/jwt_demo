package com.bancolombia.jwt_demo.model;

import java.io.Serializable;

public class AuthResponse implements Serializable {

    private static final long serialVersionUID = 6815543230364667644L;

    private String token;

    public AuthResponse(){}

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
