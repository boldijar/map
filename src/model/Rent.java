package model;

/**
 * Created by Paul on 10/8/2016.
 */
public class Rent extends IndexedModel {
    private int id;
    private int clientId;
    private int movieId;

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", movieId=" + movieId +
                '}';
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Rent(int id, int clientId, int movieId) {

        this.id = id;
        this.clientId = clientId;
        this.movieId = movieId;
    }
}
