package app.dao;

import app.models.Movie;

import java.util.List;

public interface MovieDAO {
    Movie getMovieById(int id);

    List<Movie> getAllActiveMovies();

    void create();
}
