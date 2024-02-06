package com.shop.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shop.shop.model.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "admins")
@Data
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @Column(name = "admin_name")
    private String name;

    @Column(name = "admin_dob")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Transient
    private Integer age;

    @Column(name = "admin_email")
    @NotEmpty(message = "Email is required")
    @Email(message = "Valid email is required")
    private String email;

    @Column(name = "admin_password")
    @NotEmpty(message = "Password is required")
    @Size(min = 8, message = "Password's length must be at least 8 characters long")
    private String password;

    @Column(name = "admin_role")
    private UserRole role;

    public Admin(Long id, String name, LocalDate dateOfBirth, String email, String password, UserRole role) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public Admin(Long id, String name, LocalDate dateOfBirth, String email, String password) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
    }

    public Integer getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
