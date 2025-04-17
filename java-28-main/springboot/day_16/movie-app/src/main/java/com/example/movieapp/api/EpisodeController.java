package com.example.movieapp.api;

import com.example.movieapp.model.dto.EpisodeRequest;
import com.example.movieapp.entity.Episode;
import com.example.movieapp.service.EpisodeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class EpisodeController {
    @Autowired
    private EpisodeService episodeService;

    @GetMapping("/episodes")
    public ResponseEntity<?> getEpisodes(
            @RequestParam Integer movieId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        if (movieId == null) {
            return ResponseEntity.badRequest().body("movieId là bắt buộc");
        }
        if (page < 1 || pageSize < 1) {
            return ResponseEntity.badRequest().body("page và pageSize phải lớn hơn 0");
        }

        Page<Episode> episodes = episodeService.getEpisodesByMovieId(movieId, page, pageSize);
        return ResponseEntity.ok(episodes);
    }

    @PostMapping("/episodes")
    public ResponseEntity<?> createEpisode(@Valid @RequestBody EpisodeRequest request) {
        try {
            Episode episode = episodeService.createEpisode(request);
            return new ResponseEntity<>(episode, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/episodes/{id}")
    public ResponseEntity<?> updateEpisode(@PathVariable Integer id, @Valid @RequestBody EpisodeRequest request) {
        try {
            Episode episode = episodeService.updateEpisode(id, request);
            return ResponseEntity.ok(episode);
        } catch (IllegalArgumentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/episodes/{id}")
    public ResponseEntity<?> deleteEpisode(@PathVariable Integer id) {
        try {
            episodeService.deleteEpisode(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}