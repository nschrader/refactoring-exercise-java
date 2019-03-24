package com.greatersum.rental.data;

import com.greatersum.rental.MovieDatabase;
import com.greatersum.rental.value.Days;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieRental {
    private final String movieId;
    private final Days days;

    public MovieRental(String movieId, int days) {
        this(movieId, new Days(days));
    }

    public Movie getMovie() {
        MovieDatabase mdb = MovieDatabase.getInstance();
        return mdb.find(this.movieId);
    }
}
