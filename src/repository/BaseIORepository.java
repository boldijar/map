package repository;

import model.IndexedModel;
import util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 10/28/2016.
 */
/* BaseRepository<T extends IndexedModel> implements Crudable<T> */
abstract class BaseIORepository<T extends IndexedModel> extends BaseRepository {

    private void save() {
        Utils.writeToFile(mItems, getPath());
    }

    private void load() {
        mItems = Utils.readFromFile(getPath());
    }

    abstract String getPath();

    BaseIORepository() {
        super();
        load();
        if (mItems == null) {
            mItems = new ArrayList();
        }
    }

    @Override
    public void remove(int id) {
        super.remove(id);
        save();
    }

    @Override
    public void add(IndexedModel indexedModel) {
        super.add(indexedModel);
        save();
    }

    @Override
    public void update(IndexedModel item) {
        super.update(item);
        save();
    }
}
