package edu.dnu.fpm.pz.list.core;

import edu.dnu.fpm.pz.list.exception.Validator;
import edu.dnu.fpm.pz.list.exception.WrongIndex;
import edu.dnu.fpm.pz.list.exception.WrongLength;
import edu.dnu.fpm.pz.list.interfaces.IList;

public class IndexedList<T> implements IList<T> {
    private Object[] list;
    private int count;

    public IndexedList() {
        list = new Object[50];
        count = 0;
    }

    public IndexedList(int capacity) throws WrongLength {
        Validator.validateLength(capacity);

        list = new Object[capacity];
        count = 0;
    }

    public int length() {
        return count;
    }

    public T find(int index) throws WrongIndex {
        Validator.validateIndex(index, count);

        return (T) list[index];
    }

    public void add(T item) {
        if (count == list.length - 1) {
            resize(list.length + 1);
        }
        list[count++] = item;
    }

    public void insert(int index, T item) throws WrongIndex {
        Validator.validateIndex(index, count);

        if (count == list.length - 1) {
            resize(list.length + 1);
        }

        if (count - index >= 0) {
            System.arraycopy(list, index, list, index + 1,
                    count - index);
        }

        list[index] = item;
        count++;
    }

    public T removeAt(int index) throws WrongIndex {
        Validator.validateIndex(index, count);

        T removed = (T) list[index];

        if (count - index >= 0) {
            System.arraycopy(list, index + 1, list, index,
                    count - index);
        }

        list[count] = null;
        count--;

        resize(list.length - 1);

        return removed;
    }

    private void resize(int capacity) {
        Object[] resized = new Object[capacity];

        System.arraycopy(list, 0, resized, 0, count);
        list = resized;
    }
}