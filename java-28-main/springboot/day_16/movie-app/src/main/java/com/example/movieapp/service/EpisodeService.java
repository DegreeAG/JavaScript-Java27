package com.example.movieapp.service;

import com.example.movieapp.entity.Episode;
import com.example.movieapp.entity.Movie;
import com.example.movieapp.model.dto.EpisodeRequest;
import com.example.movieapp.repository.EpisodeRepository;
import com.example.movieapp.repository.MovieRepository;
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
public class EpisodeService {
    private final EpisodeRepository episodeRepository;
    private final MovieRepository movieRepository;

    public List<Episode> findEpisodesByMovieId(Integer id) {
        return episodeRepository.findByMovie_IdAndStatusOrderByDisplayOrderAsc(id, true);
    }

    public Episode findEpisodeByDisplayOrder(Integer id, String tap) {
        Integer displayOrder = tap.equals("full") ? 1 : Integer.parseInt(tap);
        return episodeRepository.findByMovie_IdAndDisplayOrderAndStatus(id, displayOrder, true);
    }

    public Page<Episode> getEpisodesByMovieId(Integer movieId, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("displayOrder").ascending());
        return episodeRepository.findByMovie_IdAndStatus(movieId, true, pageable);
    }

    public Episode createEpisode(EpisodeRequest request) {
        // Validate movie
        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new IllegalArgumentException("Phim không tồn tại: " + request.getMovieId()));

        // Create Episode
        Episode episode = Episode.builder()
                .movie(movie)
                .name(request.getName())
                .displayOrder(request.getDisplayOrder())
                .status(request.getStatus())
                .duration(null)
                .videoUrl(null)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .publishedAt(LocalDateTime.now())
                .build();

        return episodeRepository.save(episode);
    }

    public Episode updateEpisode(Integer id, EpisodeRequest request) {
        // Validate episode
        Episode episode = episodeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tập phim không tồn tại: " + id));

        // Validate movie
        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new IllegalArgumentException("Phim không tồn tại: " + request.getMovieId()));

        // Update Episode
        episode.setMovie(movie);
        episode.setName(request.getName());
        episode.setDisplayOrder(request.getDisplayOrder());
        episode.setStatus(request.getStatus());
        episode.setDuration(null);
        episode.setVideoUrl(null);
        episode.setUpdatedAt(LocalDateTime.now());

        return episodeRepository.save(episode);
    }

    public void deleteEpisode(Integer id) {
        if (!episodeRepository.existsById(id)) {
            throw new IllegalArgumentException("Tập phim không tồn tại: " + id);
        }
        episodeRepository.deleteById(id);
    }
}