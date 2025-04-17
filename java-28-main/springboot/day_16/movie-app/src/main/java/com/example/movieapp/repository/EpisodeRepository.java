package com.example.movieapp.repository;

import com.example.movieapp.entity.Episode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    List<Episode> findByMovie_IdAndStatusOrderByDisplayOrderAsc(Integer movieId, Boolean status);

    Episode findByMovie_IdAndDisplayOrderAndStatus(Integer movieId, Integer displayOrder, Boolean status);

    Page<Episode> findByMovie_IdAndStatus(Integer movieId, Boolean status, Pageable pageable);
}