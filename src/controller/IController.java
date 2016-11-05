package controller;

import model.Client;
import model.Movie;
import model.Rent;

import java.util.List;

/**
 * Created by Paul on 10/21/2016.
 */
public interface IController {
    void addMovie(String director, String type);

    void addClient(String name, String address);

    void addRent(int clientId, int movieId);

    void deleteMovie(int id);

    void deleteClient(int id);

    void updateMovie(int id, String director, String type);

    void updateClient(int id, String name, String address);

    List<Movie> getMovies();

    List<Client> getClients();

    List<Rent> getRents();
}
