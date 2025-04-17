package com.example.movieapp.controller.web;

import com.example.movieapp.entity.Episode;
import com.example.movieapp.entity.Movie;
import com.example.movieapp.service.EpisodeService;
import com.example.movieapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private EpisodeService episodeService;

    @GetMapping("/movies")
    public String getMoviesPage(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            Model model) {
        Page<Movie> movies = movieService.getMovies(page, pageSize);
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/episodes")
    public String getEpisodesPage(
            @RequestParam Integer movieId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            Model model) {
        if (movieId == null) {
            model.addAttribute("error", "movieId là bắt buộc");
            return "episodes";
        }
        try {
            Page<Episode> episodes = episodeService.getEpisodesByMovieId(movieId, page, pageSize);
            model.addAttribute("episodes", episodes);
            model.addAttribute("movieId", movieId);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "episodes";
    }
}