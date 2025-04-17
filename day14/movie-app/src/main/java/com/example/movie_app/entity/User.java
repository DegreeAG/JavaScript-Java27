package com.example.movie_app.entity;


import com.example.movie_app.model.enums.UserRole;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
    
    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String displayName;
    private String email;
    private String phone;
    private String avatar;

    private Boolean isEnable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
