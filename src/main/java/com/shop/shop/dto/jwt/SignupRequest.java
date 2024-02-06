package com.shop.shop.dto.jwt;

import lombok.Data;

@Data
public class SignupRequest {

    private String email;

    private String name;

    private String password;
}
