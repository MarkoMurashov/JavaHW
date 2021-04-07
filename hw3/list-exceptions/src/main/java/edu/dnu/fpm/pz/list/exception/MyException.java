package edu.dnu.fpm.pz.list.exception;

public class MyException extends Exception {

    protected Exception cause;

    public MyException(String message){
        super(message);
    }

    public void log(){
        if(cause != null) {
            System.out.println("Error: " + cause.getMessage());
            cause.printStackTrace();
        }
    }
}
