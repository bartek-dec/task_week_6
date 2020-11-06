package com.example.mail.service;

import com.example.mail.domain.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    Movie add(Movie movie);
}
