package edu.dnu.fpm.pz.list.exception;

public class Validator {
    public static void validateIndex(int index, int listLength) throws WrongIndex {
        if (index < 0 || index >= listLength) {
            throw new WrongIndex(index);
        }
    }

    public static void validateLength(int listLength) throws WrongLength {
        if (listLength <= 0) {
            throw new WrongLength(listLength);
        }
    }
}
