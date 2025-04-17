package com.example.movieapp.model.dto;

import com.example.movieapp.model.enums.MovieType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class MovieRequest {
    @NotEmpty(message = "Tên phim không được để trống")
    private String name;

    @NotEmpty(message = "Trailer URL không được để trống")
    private String trailerUrl;

    @NotEmpty(message = "Mô tả không được để trống")
    private String description;

    @NotNull(message = "Năm phát hành không được để trống")
    private Integer releaseYear;

    @NotNull(message = "Loại phim không được để trống")
    private MovieType type;

    @NotNull(message = "Trạng thái không được để trống")
    private Boolean status;

    @NotNull(message = "Quốc gia không được để trống")
    private Integer countryId;

    private List<Integer> genreIds;
    private List<Integer> actorIds;
    private List<Integer> directorIds;
}