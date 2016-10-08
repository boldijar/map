package model;

/**
 * Created by Paul on 10/8/2016.
 */
public class Movie extends IndexedModel {
    private int id;
    private String director;
    private String type;

    public Movie(int id, String director, String type) {
        this.id = id;
        this.director = director;
        this.type = type;
    }

    public Movie() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", director='" + director + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
