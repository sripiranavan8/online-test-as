package com.sripiranavan.java.springboot.project.onlinetestas.repositories;

import com.sripiranavan.java.springboot.project.onlinetestas.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findClientByClientId(String id);
}
