package com.shop.shop.dto;

import com.shop.shop.model.Order;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Data
@NoArgsConstructor
public class ClientDto {

    @NotNull
    private Long id;

    @NotBlank(message = "name field is mandatory")
    private String name;

    @NotBlank(message = "address field is mandatory")
    private String address;

    @NotBlank(message = "email field is mandatory")
    @Email(message = "invalid email")
    private String email;

    @NotBlank(message = "password field is mandatory")
    private String password;

    @NotBlank(message = "phone field is mandatory")
    private String phone;

    private List<Order> orders;

    public ClientDto(String name, String address, String email, String password, String phone, List<Order> orders) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.orders = orders;
    }

    public ClientDto(String name, String address, String email, String password, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public ClientDto(Long id, String name, String address, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public String getPassword() {
        return new BCryptPasswordEncoder().encode(password);
    }
}
