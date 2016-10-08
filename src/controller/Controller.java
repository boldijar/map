package controller;

import model.Client;
import model.Movie;
import repository.ClientRepository;
import repository.MovieRepository;
import util.Array;

/**
 * Created by Paul on 10/8/2016.
 */
public class Controller {
    private final ClientRepository clientRepository;
    private final MovieRepository movieRepository;

    private int lastMovieId = 0;
    private int lastClientId = 0;

    public Controller(ClientRepository clientRepository, MovieRepository movieRepository) {
        this.clientRepository = clientRepository;
        this.movieRepository = movieRepository;
    }

    public void addMovie(String director, String type) {
        movieRepository.add(new Movie(lastMovieId++, director, type));
    }

    public void addClient(String name, String address) {
        clientRepository.add(new Client(lastClientId++, name, address));
    }

    public void deleteMovie(int id) {
        movieRepository.remove(id);
    }

    public void deleteClient(int id) {
        clientRepository.remove(id);
    }

    public void updateMovie(int id, String director, String type) {
        movieRepository.update(new Movie(id, director, type));
    }

    public void updateClient(int id, String name, String address) {
        clientRepository.update(new Client(id, name, address));
    }

    public Array<Movie> getMovies() {
        return movieRepository.listAll();
    }

    public Array<Client> getClients() {
        return clientRepository.listAll();
    }
}