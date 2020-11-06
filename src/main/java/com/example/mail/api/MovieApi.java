package com.example.mail.api;

import com.example.mail.service.annotation.EmailAspect;
import com.example.mail.domain.Movie;
import com.example.mail.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieApi {

    private MovieService movieService;

    @Autowired
    public MovieApi(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAll() {
        return new ResponseEntity<>(movieService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @EmailAspect
    public ResponseEntity<Movie> addMovie(@Validated @RequestBody Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(movieService.add(movie), HttpStatus.OK);
    }
}
