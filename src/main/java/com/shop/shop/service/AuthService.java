package com.shop.shop.service;

import com.shop.shop.dto.jwt.SignupRequest;
import com.shop.shop.model.Customer;

public interface AuthService {
    Customer createCustomer(SignupRequest signupRequest);
}
