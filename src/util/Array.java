package util;

import java.util.Iterator;

/**
 * Created by Paul on 10/8/2016.
 */
public class Array<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int CAPACITY_STEP = 5;

    private Object[] mItems;
    private int size;
    private int capacity;

    public Array() {
        mItems = new Object[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
    }

    @SuppressWarnings("unchecked")
    public T get(int position) {
        return (T) mItems[position];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return get(index++);
            }
        };
    }

    public void add(T object) {
        checkSize();
        mItems[size++] = object;
    }

    public void remove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(mItems, index + 1, mItems, index,
                    numMoved);
        mItems[--size] = null;
    }

    public void set(int position, T object) {
        mItems[position] = object;
    }

    private void checkSize() {
        if (size == capacity) {
            increaseCapacity();
        }
    }

    private void increaseCapacity() {
        int newCapacity = capacity + CAPACITY_STEP;
        Object[] newItems = new Object[newCapacity];
        System.arraycopy(mItems, 0, newItems, 0, size);
        mItems = newItems;
        capacity = newCapacity;
    }

    static public void main(String[] args) {
        Array<String> texts = new Array<>();
        for (int i = 1; i <= 20; i++)
            texts.add("A" + i);
        texts.remove(2);
        for (String text : texts) {
            System.out.println(text);
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String output = "";
        for (Object object : this) {
            output += object.toString() + "\n";
        }
        return output;
    }
}
