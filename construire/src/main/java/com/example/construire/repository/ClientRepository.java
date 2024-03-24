package com.example.construire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.construire.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByEmail(String email);

}
