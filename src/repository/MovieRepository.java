package repository;

import model.Movie;

/**
 * Created by Paul on 10/8/2016.
 */
public class MovieRepository extends BaseIORepository<Movie> {

    @Override
    String getPath() {
        return getClass().getName();
    }
}
