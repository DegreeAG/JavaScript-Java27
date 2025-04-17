package com.example.movie_app.entity;

import com.example.movie_app.model.enums.MovieType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id tự động
    private Integer id;

    @Column(nullable = false, unique = true) //Ko được để trống, tên duy nhất
    private String name;
    private String slug;

    @Column(columnDefinition = "Text")
    private String description;

    private String thumbnail;
    private Integer releaseYear;
    private Boolean status;

    @Column(columnDefinition = "double default 5.0")
    private Double rating;

    //type
    @Enumerated(EnumType.STRING)
    private MovieType type;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime publishedAt;
}
