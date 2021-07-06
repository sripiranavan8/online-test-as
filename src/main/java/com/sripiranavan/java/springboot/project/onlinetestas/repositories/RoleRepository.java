package com.sripiranavan.java.springboot.project.onlinetestas.repositories;

import com.sripiranavan.java.springboot.project.onlinetestas.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
