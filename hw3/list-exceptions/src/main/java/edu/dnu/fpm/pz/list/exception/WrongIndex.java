package edu.dnu.fpm.pz.list.exception;

public class WrongIndex extends MyException {
    public WrongIndex(int index) {
        super("Wrong index " + index + " !!!") ;
        cause = this;
    }
}
