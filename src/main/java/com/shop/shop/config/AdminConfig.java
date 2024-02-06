package com.shop.shop.config;

import com.shop.shop.model.Admin;
import com.shop.shop.model.enums.UserRole;
import com.shop.shop.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class AdminConfig {

    @Bean
    CommandLineRunner commandLineRunnerAdmin(AdminRepository adminRepository) {
        return args -> {
            Admin admin1 = new Admin(1L, "Admin 1", LocalDate.of(1995, 3, 7),
                    "admin1@gmail.com", new BCryptPasswordEncoder().encode("Admin 1"), UserRole.ADMIN);
            Admin admin2 = new Admin(2L, "Admin 2", LocalDate.of(2005, 9, 10),
                    "admin2@yahoo.com", new BCryptPasswordEncoder().encode("Admin 1"), UserRole.ADMIN);

            adminRepository.saveAll(List.of(admin1, admin2));
        };
    }
}
