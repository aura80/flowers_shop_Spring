package com.shop.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder       // din Lombok feature - produce complex builder API - lucreaza cu fieldurile din superclase spre deosebire de @Builder - nu e compatibil cu @Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @JsonInclude(NON_NULL)
    @Column(name = "client_name", unique = true)
    @NotEmpty(message = "Name is required")
    private String name;

    @JsonInclude(NON_NULL)
    @Column(name = "client_address")
    @NotEmpty(message = "Address is required")
    private String address;

    @JsonInclude(NON_NULL)
    @Column(name = "client_email", unique = true)
    @NotEmpty(message = "Email is required")
    @Email(message = "Valid email is required")
    private String email;

    @JsonInclude(NON_NULL)
    @Column(name = "client_password")
    @NotEmpty(message = "Password is required")
    @Size(min = 8, message = "Password's length must be at least 8 characters long")
    private String password;

    @JsonInclude(NON_NULL)
    @Column(name = "client_phone", unique = true)
    @NotEmpty(message = "Phone no. is required")
    private String phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)  // PERSIST
    @JsonIgnore
    private List<Order> orders;

    public Client(String name, String address, String email, String password, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    //    vechi
    public Client(Long id, String name, String address, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

}
