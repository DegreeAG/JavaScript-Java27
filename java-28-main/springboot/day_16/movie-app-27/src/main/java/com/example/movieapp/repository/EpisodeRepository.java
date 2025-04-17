package com.example.movieapp.repository;

import com.example.movieapp.entity.Episode;
import com.example.movieapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    List<Episode> findByMovie_IdAndStatusOrderByDisplayOrderAsc(Integer id, boolean status);

    Episode findByMovie_IdAndDisplayOrderAndStatus(Integer id, Integer displayOrder, boolean status);
}