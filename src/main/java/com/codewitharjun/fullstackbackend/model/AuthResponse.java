package com.codewitharjun.fullstackbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class AuthResponse {
    private String Token;
    private String Type ="Bearer ";

    public AuthResponse(String token){
        this.Token=token;
    }
}
