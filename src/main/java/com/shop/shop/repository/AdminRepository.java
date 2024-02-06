package com.shop.shop.repository;

import com.shop.shop.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> getAdminByName(String name);

    @Query("SELECT c FROM Admin c WHERE c.name = :name AND c.email = :email")
    Optional<Admin> getAdminByNameAndEmail(@Param("name") String name, @Param("email") String email);
}
