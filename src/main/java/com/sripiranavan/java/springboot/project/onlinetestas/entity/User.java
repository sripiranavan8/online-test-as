package com.sripiranavan.java.springboot.project.onlinetestas.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role userRole;
}
