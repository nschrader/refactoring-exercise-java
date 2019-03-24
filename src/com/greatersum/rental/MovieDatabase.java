package com.greatersum.rental;

import com.greatersum.rental.data.Movie;
import com.greatersum.rental.data.MovieCode;
import com.greatersum.rental.value.Title;

import java.util.HashMap;

public class MovieDatabase {
    private static final MovieDatabase instance = new MovieDatabase();

    public static MovieDatabase getInstance() {
        return instance;
    }

    private HashMap<String, Movie> movies = new HashMap();

    private MovieDatabase() {
        this.movies.put("F001", new Movie(new Title("Ran"), MovieCode.REGULAR));
        this.movies.put("F002", new Movie(new Title("Trois Couleurs: Bleu"), MovieCode.REGULAR));
        this.movies.put("F003", new Movie(new Title ("Cars 2"), MovieCode.CHILDREN));
        this.movies.put("F004", new Movie(new Title("Latest Hit Release"), MovieCode.NEW));
    }

    public Movie find(String movieId) {
        return this.movies.get(movieId);
    }
}
