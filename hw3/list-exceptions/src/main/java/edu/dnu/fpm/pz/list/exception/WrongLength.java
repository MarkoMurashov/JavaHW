package edu.dnu.fpm.pz.list.exception;

public class WrongLength extends MyException{
    public WrongLength(int length) {
        super("Wrong length " + length + " !!!");
        cause = this;
    }
}
