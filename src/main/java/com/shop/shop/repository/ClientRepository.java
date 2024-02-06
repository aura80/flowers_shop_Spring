package com.shop.shop.repository;

import com.shop.shop.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> getClientByName(@Param("name") String name); // param ?

    @Query("SELECT c FROM Client c WHERE c.name = :name AND c.phone = :phone")
    Optional<Client> getClientByNameAndPhone(@Param("name") String name, @Param("phone") String phone);

    @Query("SELECT c FROM Client c WHERE c.email = :email AND c.password = :password")
    Optional<Client> getClientByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    Optional<Client> findClientByEmail(@Param("email") String email);
}
