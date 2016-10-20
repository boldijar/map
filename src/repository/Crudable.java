package repository;

import java.util.List;

/**
 * Created by Paul on 10/20/2016.
 */
interface Crudable<T> {
    void add(T t);

    void remove(int id);

    void update(T item);

    List<T> listAll();
}
