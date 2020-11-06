package com.example.mail.service;

import com.example.mail.domain.Movie;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private List<Movie> movies;

    public MovieServiceImpl() {
        movies = new ArrayList<>();

        movies.add(new Movie(1L, "Joker", LocalDate.of(2019, 1, 1)));
        movies.add(new Movie(2L, "Irlandczyk", LocalDate.of(2019, 2, 2)));
        movies.add(new Movie(3L, "La Mans '66", LocalDate.of(2019, 3, 3)));
        movies.add(new Movie(4L, "1917", LocalDate.of(2019, 4, 4)));
        movies.add(new Movie(5L, "Pewnego razu...w Holywood", LocalDate.of(2019, 5, 5)));
    }

    @Override
    public List<Movie> findAll() {
        return movies;
    }

    @Override
    public Movie add(Movie movie) {
        Long highestId = getHighestId();
        movie.setId(++highestId);
        movies.add(movie);

        return movie;
    }

    private Long getHighestId() {
        return movies.stream()
                .map(Movie::getId)
                .max(Comparator.comparingLong(Long::longValue)).get();
    }
}
