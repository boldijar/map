package repository;

import model.IndexedModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 10/8/2016.
 */
public class BaseRepository<T extends IndexedModel> implements Crudable<T> {

    protected List<T> mItems = new ArrayList<>();

    @Override
    public void add(T t) {
        mItems.add(t);
    }

    @Override
    public void remove(int id) {
        int indexToRemove = -1;
        for (int i = 0; i < mItems.size(); i++) {
            if (mItems.get(i).getId() == id) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1)
            mItems.remove(indexToRemove);
    }

    @Override
    public void update(T item) {
        for (int i = 0; i < mItems.size(); i++) {
            if (mItems.get(i).getId() == item.getId()) {
                mItems.set(i, item);
            }
        }
    }

    @Override
    public List<T> listAll() {
        return new ArrayList<>(mItems);
    }


}
