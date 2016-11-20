package controller;

import model.Client;
import model.Movie;
import repository.BaseRepository;
import repository.MovieRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Paul on 11/18/2016.
 */
public class MovieController implements IMovieController {

    private final BaseRepository<Movie> movieRepository;
    private int lastMovieId = 0;

    public MovieController(BaseRepository<Movie> movieRepository) {
        this.movieRepository = movieRepository;
        this.lastMovieId = movieRepository.listAll().size();
    }

    @Override
    public void addMovie(String director, String type) {
        movieRepository.add(new Movie(lastMovieId++, director, type));
    }

    @Override
    public void deleteMovie(int id) {
        movieRepository.remove(id);
    }

    @Override
    public void updateMovie(int id, String director, String type) {
        movieRepository.update(new Movie(id, director, type));
    }

    @Override
    public List<Movie> getMoviesByDirector(String director) {
        List<Movie> clients = movieRepository.listAll();
        return clients.stream().filter(client -> client.getDirector().equals(director)).collect(Collectors.toList());
    }

    @Override
    public List<Movie> getMoviesByType(String type) {
        List<Movie> clients = movieRepository.listAll();
        return clients.stream().filter(client -> client.getType().equals(type)).collect(Collectors.toList());
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.listAll();
    }

    @Override
    public List<Movie> getMoviesSortedBy(boolean byDirector, boolean byType, boolean ascending) {
        List<Movie> movies = getMovies();
        Stream<Movie> stream = movies.stream();
        if (byDirector) {
            stream.sorted((o1, o2) -> o1.getDirector().compareTo(o2.getDirector()));
        }
        if (byType) {
            stream.sorted((o1, o2) -> o1.getType().compareTo(o2.getType()));
        }
        movies = stream.collect(Collectors.toList());
        if (!ascending) {
            Collections.reverse(movies);
        }
        return movies;
    }
}
