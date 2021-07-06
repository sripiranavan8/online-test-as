package com.sripiranavan.java.springboot.project.onlinetestas.repositories;

import com.sripiranavan.java.springboot.project.onlinetestas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUserName(String username);
}
