package com.example.movie_app.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private String slug;

    private String avatar;

    @Column(columnDefinition = "TEXT")
    private String bio;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
