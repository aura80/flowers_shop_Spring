package com.shop.shop.dto.jwt;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;

    private String password;
}
