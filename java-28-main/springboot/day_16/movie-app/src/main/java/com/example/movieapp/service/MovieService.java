package com.example.movieapp.service;

import com.example.movieapp.entity.*;
import com.example.movieapp.model.dto.MovieRequest;
import com.example.movieapp.model.enums.MovieType;
import com.example.movieapp.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final CountryRepository countryRepository;
    private final GenreRepository genreRepository;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;

    public List<Movie> findHotMovie(Boolean status, Integer limit) {
        return movieRepository.findHotMovie(status, limit);
    }

    public Page<Movie> findByType(MovieType type, Boolean status, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("publishedAt").descending());
        Page<Movie> moviePage = movieRepository.findByTypeAndStatus(type, status, pageable);
        return moviePage;
    }

    public Movie findMovieDetails(Integer id, String slug) {
        return movieRepository.findByIdAndSlugAndStatus(id, slug, true);
    }

    public Page<Movie> getMovies(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return movieRepository.findAll(pageable);
    }

    public Movie createMovie(MovieRequest request) {
        // Validate related entities
        Country country = countryRepository.findById(request.getCountryId())
                .orElseThrow(() -> new IllegalArgumentException("Quốc gia không tồn tại: " + request.getCountryId()));

        List<Genre> genres = request.getGenreIds() != null
                ? genreRepository.findAllById(request.getGenreIds())
                : List.of();
        if (request.getGenreIds() != null && genres.size() != request.getGenreIds().size()) {
            throw new IllegalArgumentException("Một hoặc nhiều thể loại không tồn tại");
        }

        List<Actor> actors = request.getActorIds() != null
                ? actorRepository.findAllById(request.getActorIds())
                : List.of();
        if (request.getActorIds() != null && actors.size() != request.getActorIds().size()) {
            throw new IllegalArgumentException("Một hoặc nhiều diễn viên không tồn tại");
        }

        List<Director> directors = request.getDirectorIds() != null
                ? directorRepository.findAllById(request.getDirectorIds())
                : List.of();
        if (request.getDirectorIds() != null && directors.size() != request.getDirectorIds().size()) {
            throw new IllegalArgumentException("Một hoặc nhiều đạo diễn không tồn tại");
        }

        // Create Movie
        Movie movie = Movie.builder()
                .name(request.getName())
                .trailer(request.getTrailerUrl())
                .description(request.getDescription())
                .releaseYear(request.getReleaseYear())
                .type(request.getType())
                .status(request.getStatus())
                .country(country)
                .genres(genres)
                .actors(actors)
                .directors(directors)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .publishedAt(LocalDateTime.now())
                .rating(5.0) // Default rating
                .build();

        return movieRepository.save(movie);
    }

    public Movie updateMovie(Integer id, MovieRequest request) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Phim không tồn tại: " + id));

        Country country = countryRepository.findById(request.getCountryId())
                .orElseThrow(() -> new IllegalArgumentException("Quốc gia không tồn tại: " + request.getCountryId()));

        List<Genre> genres = request.getGenreIds() != null
                ? genreRepository.findAllById(request.getGenreIds())
                : List.of();
        if (request.getGenreIds() != null && genres.size() != request.getGenreIds().size()) {
            throw new IllegalArgumentException("Một hoặc nhiều thể loại không tồn tại");
        }

        List<Actor> actors = request.getActorIds() != null
                ? actorRepository.findAllById(request.getActorIds())
                : List.of();
        if (request.getActorIds() != null && actors.size() != request.getActorIds().size()) {
            throw new IllegalArgumentException("Một hoặc nhiều diễn viên không tồn tại");
        }

        List<Director> directors = request.getDirectorIds() != null
                ? directorRepository.findAllById(request.getDirectorIds())
                : List.of();
        if (request.getDirectorIds() != null && directors.size() != request.getDirectorIds().size()) {
            throw new IllegalArgumentException("Một hoặc nhiều đạo diễn không tồn tại");
        }

        movie.setName(request.getName());
        movie.setTrailer(request.getTrailerUrl());
        movie.setDescription(request.getDescription());
        movie.setReleaseYear(request.getReleaseYear());
        movie.setType(request.getType());
        movie.setStatus(request.getStatus());
        movie.setCountry(country);
        movie.setGenres(genres);
        movie.setActors(actors);
        movie.setDirectors(directors);
        movie.setUpdatedAt(LocalDateTime.now());

        return movieRepository.save(movie);
    }

    public void deleteMovie(Integer id) {
        if (!movieRepository.existsById(id)) {
            throw new IllegalArgumentException("Phim không tồn tại: " + id);
        }
        movieRepository.deleteById(id);
    }
}