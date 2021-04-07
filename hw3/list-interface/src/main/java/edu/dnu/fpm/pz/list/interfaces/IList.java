package edu.dnu.fpm.pz.list.interfaces;

import edu.dnu.fpm.pz.list.exception.WrongIndex;

public interface IList<T> {
    int length();
    T find(int index) throws WrongIndex;
    void add(T item);
    void insert(int index, T item) throws WrongIndex;
    T removeAt(int index) throws WrongIndex;
}
