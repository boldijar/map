package controller;

import model.Movie;

import java.util.List;

/**
 * Created by Paul on 11/18/2016.
 */
public interface IMovieController {
    void addMovie(String director, String type);

    void deleteMovie(int id);

    void updateMovie(int id, String director, String type);

    List<Movie> getMoviesByDirector(String director);

    List<Movie> getMoviesByType(String type);

    List<Movie> getMovies();

    List<Movie> getMoviesSortedBy(boolean byDirector, boolean byType, boolean ascending);
}
