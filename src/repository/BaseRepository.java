package repository;

import model.IndexedModel;
import util.Array;

/**
 * Created by Paul on 10/8/2016.
 */
public class BaseRepository<T extends IndexedModel> {

    private Array<T> mItems = new Array<>();

    public void add(T t) {
        mItems.add(t);
    }

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

    public void update(T item) {
        for (int i = 0; i < mItems.size(); i++) {
            if (mItems.get(i).getId() == item.getId()) {
                mItems.set(i, item);
            }
        }
    }

    public Array<T> listAll() {
        return mItems;
    }


}
