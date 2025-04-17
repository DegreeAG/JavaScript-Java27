package com.example.movie_app.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "medias")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String mediaType;

    @Column( nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private String url;

    private Long size;

    private LocalDateTime createdAt;
}
