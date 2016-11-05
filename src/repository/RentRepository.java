package repository;

import model.Rent;

/**
 * Created by Paul on 10/8/2016.
 */
public class RentRepository extends BaseIORepository<Rent> {

    @Override
    String getPath() {
        return getClass().getName();
    }
}
