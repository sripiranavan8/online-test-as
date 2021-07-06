package com.sripiranavan.java.springboot.project.onlinetestas.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "userRole",cascade = CascadeType.ALL)
    private Set<User> user;
}
