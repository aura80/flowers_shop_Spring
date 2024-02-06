package com.shop.shop.dto;

import com.shop.shop.model.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AdminDto {

    @NotNull
    private Long id;

    @NotBlank(message = "name field is mandatory")
    private String name;

    @NotBlank(message = "date of birth field is mandatory")
    private LocalDate dateOfBirth;

    private Integer age;

    @NotBlank(message = "email field is mandatory")
    @Email(message = "invalid email")
    private String email;

    @NotBlank(message = "email field is mandatory")
    private String password;

    private UserRole role;

    public AdminDto(String name, LocalDate dateOfBirth, String email, String password) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return new BCryptPasswordEncoder().encode(password);
    }
}
