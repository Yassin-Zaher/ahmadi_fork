package com.codewitharjun.fullstackbackend.model;

import lombok.Data;

@Data
public class RegisterAuth {
    private String name;
    private String username;
    private String email;
    private String password;
}
